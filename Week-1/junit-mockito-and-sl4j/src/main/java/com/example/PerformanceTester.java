package com.example;

public class PerformanceTester {

    public long sumUpTo(long limit) {
        long sum = 0;
        for (long number = 1; number <= limit; number++) {
            sum += number;
        }
        return sum;
    }
}
