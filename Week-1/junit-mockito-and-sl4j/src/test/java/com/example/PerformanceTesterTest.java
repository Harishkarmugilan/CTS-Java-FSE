package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTesterTest {

    private final PerformanceTester performanceTester = new PerformanceTester();

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void shouldCompleteWithinTimeout() {
        assertEquals(5000050000L, performanceTester.sumUpTo(100000L));
    }
}
