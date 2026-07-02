package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerParameterizedTest {

    private final EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void shouldReturnTrueForEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number));
    }
}
