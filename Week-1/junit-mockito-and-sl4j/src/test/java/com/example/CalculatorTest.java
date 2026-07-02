package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void shouldAddNumbers() {
        assertEquals(9, calculator.add(4, 5));
    }

    @Test
    public void shouldSubtractNumbers() {
        assertEquals(3, calculator.subtract(8, 5));
    }

    @Test
    public void shouldMultiplyNumbers() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    public void shouldDivideNumbers() {
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
    }
}
