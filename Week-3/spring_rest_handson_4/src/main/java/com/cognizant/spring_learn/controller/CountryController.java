package com.cognizant.spring_learn.controller;

import java.util.List;

import jakarta.validation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    // GET ALL COUNTRIES

    @GetMapping
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        List<Country> countries =
                countryService  .getAllCountries();

        LOGGER.info("END");

        return countries;
    }


    // GET COUNTRY BY CODE

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code)
            throws CountryNotFoundException {

        LOGGER.info("START");

        Country country =
                countryService.getCountry(code);

        LOGGER.info("END");

        return country;
    }


    // CREATE COUNTRY
    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {

        LOGGER.info("START");

        Country newCountry =
                countryService.addCountry(country);

        LOGGER.info("END");

        return newCountry;
    }


    // UPDATE COUNTRY

    @PutMapping
    public Country updateCountry(@RequestBody Country country)
            throws CountryNotFoundException {

        LOGGER.info("START");

        Country updatedCountry =
                countryService.updateCountry(country);

        LOGGER.info("END");

        return updatedCountry;
    }


    // DELETE COUNTRY

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code)
            throws CountryNotFoundException {

        LOGGER.info("START");

        countryService.deleteCountry(code);

        LOGGER.info("END");
    }
}