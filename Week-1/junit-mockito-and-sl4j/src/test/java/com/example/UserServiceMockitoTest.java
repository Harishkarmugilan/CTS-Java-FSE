package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceMockitoTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldMockUserRepositoryInUserService() {
        UserEntity user = new UserEntity(1L, "Ava", "ava@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        assertEquals("Ava", userService.getUser(1L).getName());
    }

    @Test
    void shouldMockUserRepositorySave() {
        UserEntity user = new UserEntity(2L, "Ben", "ben@example.com");
        when(userRepository.save(user)).thenReturn(user);

        assertEquals("Ben", userService.createUser(user).getName());
    }

    @Test
    void shouldThrowWhenUserIsMissing() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        UserNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(UserNotFoundException.class, () -> userService.getUser(99L));
        assertEquals("User not found", exception.getMessage());
    }
}
