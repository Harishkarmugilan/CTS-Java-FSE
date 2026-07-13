package com.cognizant.orm_learn.service.exception;

public class CountryNotFoundException extends Exception {

    public CountryNotFoundException() {
        super("Country not found");
    }
}