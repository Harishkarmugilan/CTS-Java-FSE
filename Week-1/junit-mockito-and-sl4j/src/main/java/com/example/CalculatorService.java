package com.example;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final Calculator calculator = new Calculator();

    public int add(int left, int right) {
        return calculator.add(left, right);
    }

    public int subtract(int left, int right) {
        return calculator.subtract(left, right);
    }

    public int multiply(int left, int right) {
        return calculator.multiply(left, right);
    }

    public double divide(double left, double right) {
        return calculator.divide(left, right);
    }
}
