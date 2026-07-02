package com.example;

public class Calculator {

    public int add(int left, int right) {
        return left + right;
    }

    public int subtract(int left, int right) {
        return left - right;
    }

    public int multiply(int left, int right) {
        return left * right;
    }

    public double divide(double left, double right) {
        if (right == 0.0d) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return left / right;
    }
}
