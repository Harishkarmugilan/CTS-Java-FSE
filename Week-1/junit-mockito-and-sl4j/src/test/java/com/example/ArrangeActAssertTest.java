package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrangeActAssertTest {

    private Calculator calculator;
    private int result;

    @Before
    public void setUp() {
        calculator = new Calculator();
        result = 0;
    }

    @After
    public void tearDown() {
        calculator = null;
        result = 0;
    }

    @Test
    public void shouldFollowArrangeActAssert() {
        int left = 6;
        int right = 4;

        result = calculator.add(left, right);

        assertEquals(10, result);
    }
}
