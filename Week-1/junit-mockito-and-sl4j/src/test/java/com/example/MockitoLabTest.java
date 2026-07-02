package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoLabTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private MessageSender messageSender;

    private OrderService orderService;

    @Test
    void shouldMockAndStubDependencies() {
        orderService = new OrderService(orderRepository, messageSender);
        when(orderRepository.nextReference()).thenReturn("REF-1");
        when(orderRepository.findById(1)).thenReturn("Book");

        assertEquals("REF-1", orderService.saveOrder("Book"));
    }

    @Test
    void shouldVerifyInteractions() {
        orderService = new OrderService(orderRepository, messageSender);
        when(orderRepository.nextReference()).thenReturn("REF-2");

        orderService.saveOrder("Pen");

        verify(orderRepository).save("Pen");
        verify(messageSender).send("Saved Pen");
    }

    @Test
    void shouldUseArgumentMatchers() {
        orderService = new OrderService(orderRepository, messageSender);
        when(orderRepository.findById(anyInt())).thenReturn("Matched");

        assertEquals("Matched", orderService.findOrder(7));
        verify(orderRepository).findById(anyInt());
    }

    @Test
    void shouldHandleVoidMethods() {
        orderService = new OrderService(orderRepository, messageSender);
        doNothing().when(messageSender).send("Saved Table");
        when(orderRepository.nextReference()).thenReturn("REF-3");

        assertEquals("REF-3", orderService.saveOrder("Table"));
    }

    @Test
    void shouldReturnMultipleValues() {
        orderService = new OrderService(orderRepository, messageSender);
        when(orderRepository.nextReference()).thenReturn("A", "B");

        assertEquals("A", orderService.saveOrder("Item1"));
        assertEquals("B", orderService.saveOrder("Item2"));
    }

    @Test
    void shouldVerifyInteractionOrder() {
        orderService = new OrderService(orderRepository, messageSender);
        when(orderRepository.nextReference()).thenReturn("REF-4");

        orderService.saveOrder("Lamp");

        InOrder ordered = inOrder(orderRepository, messageSender);
        ordered.verify(orderRepository).save("Lamp");
        ordered.verify(messageSender).send("Saved Lamp");
        ordered.verify(orderRepository).nextReference();
    }

    @Test
    void shouldHandleVoidMethodsThrowingExceptions() {
        orderService = new OrderService(orderRepository, messageSender);
        doThrow(new IllegalStateException("failed")).when(messageSender).send("Saved Chair");

        IllegalStateException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> orderService.saveOrder("Chair"));
        assertEquals("failed", exception.getMessage());
    }
}
