package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void firstTest() {
        assertEquals(1, 1);
    }

    @Test
    @Order(2)
    void secondTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(3)
    void thirdTest() {
        assertEquals(3, 1 + 2);
    }
}
