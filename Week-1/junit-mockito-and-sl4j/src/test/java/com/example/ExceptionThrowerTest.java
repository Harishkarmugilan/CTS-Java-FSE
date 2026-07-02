package com.example;

import org.junit.Test;

public class ExceptionThrowerTest {

    private final ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeValues() {
        exceptionThrower.throwIfNegative(-1);
    }
}
