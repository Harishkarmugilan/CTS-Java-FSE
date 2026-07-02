package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdvancedMockitoLabTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private RestClient restClient;

    @Mock
    private FileReaderPort fileReaderPort;

    @Mock
    private FileWriterPort fileWriterPort;

    @Mock
    private NetworkClient networkClient;

    @Test
    void shouldMockRepository() {
        when(orderRepository.findById(100)).thenReturn("Order-100");

        assertEquals("Order-100", orderRepository.findById(100));
    }

    @Test
    void shouldMockRestClient() {
        when(restClient.get("/api/users/1")).thenReturn("User-1");

        assertEquals("User-1", restClient.get("/api/users/1"));
    }

    @Test
    void shouldMockFileReaderAndWriter() {
        when(fileReaderPort.read("input.txt")).thenReturn("content");

        String content = fileReaderPort.read("input.txt");
        fileWriterPort.write("output.txt", content);

        verify(fileWriterPort).write("output.txt", "content");
    }

    @Test
    void shouldMockNetworkClient() {
        when(networkClient.fetch("localhost")).thenReturn("online");

        assertEquals("online", networkClient.fetch("localhost"));
    }

    @Test
    void shouldReturnMultipleValues() {
        when(restClient.get("/status")).thenReturn("ready", "busy");

        assertEquals("ready", restClient.get("/status"));
        assertEquals("busy", restClient.get("/status"));
    }
}
