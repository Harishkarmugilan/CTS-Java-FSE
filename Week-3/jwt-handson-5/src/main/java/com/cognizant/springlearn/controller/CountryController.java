package com.cognizant.springlearn.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/countries")
    public List<String> getCountries() {
        logger.debug("CountryController getCountries start");
        List<String> countries = Arrays.asList("India", "United States", "United Kingdom");
        logger.debug("CountryController getCountries end");
        return countries;
    }
}
