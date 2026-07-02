package com.example;

public class ExceptionThrower {

    public void throwIfNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }
}
