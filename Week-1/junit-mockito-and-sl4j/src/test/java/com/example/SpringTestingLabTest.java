package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringTestingLabTest {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldUnitTestCalculatorService() {
        assertEquals(9, calculatorService.add(4, 5));
    }

    @Test
    void shouldTestUserControllerUsingMockMvc() throws Exception {
        UserEntity savedUser = userRepository.save(new UserEntity(null, "Mila", "mila@example.com"));

        mockMvc.perform(get("/users/{id}", savedUser.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(savedUser.getId().intValue()))
            .andExpect(jsonPath("$.name").value("Mila"))
            .andExpect(jsonPath("$.email").value("mila@example.com"));
    }

    @Test
    @SuppressWarnings("null")
    void shouldTestPostEndpoint() throws Exception {
        UserEntity user = new UserEntity(null, "Lia", "lia@example.com");

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("Lia"))
            .andExpect(jsonPath("$.email").value("lia@example.com"));
    }

    @Test
    void shouldTestServiceExceptionHandling() {
        UserNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(UserNotFoundException.class, () -> userService.getUser(999L));
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void shouldTestCustomRepositoryQuery() {
        userRepository.save(new UserEntity(null, "Leah", "leah@example.com"));

        UserEntity user = userRepository.findByEmail("leah@example.com").orElseThrow();

        assertEquals("Leah", user.getName());
    }

    @Test
    void shouldTestControllerAdvice() throws Exception {
        mockMvc.perform(get("/users/999").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("User not found"));
    }

    @Test
    void shouldRunSpringBootIntegrationTest() throws Exception {
        UserEntity user = userRepository.save(new UserEntity(null, "Owen", "owen@example.com"));

        mockMvc.perform(get("/users/{id}", user.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Owen"))
            .andExpect(jsonPath("$.email").value("owen@example.com"));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "4,5,9", "7,8,15"})
    void shouldRunParameterizedTest(int left, int right, int expected) {
        assertEquals(expected, calculatorService.add(left, right));
    }

    @Test
    void shouldFindUsersByName() {
        userRepository.save(new UserEntity(null, "Zoe", "zoe1@example.com"));
        userRepository.save(new UserEntity(null, "Zoe", "zoe2@example.com"));

        List<UserEntity> users = userRepository.findByName("Zoe");

        assertEquals(2, users.size());
        assertNotNull(users.get(0).getEmail());
    }
}
