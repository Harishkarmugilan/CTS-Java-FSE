package com.cognizant.springrest4.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest4.model.Country;
import com.cognizant.springrest4.service.CountryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService = new CountryService();

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("START");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("END");
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START");
        Country country = countryService.getCountry(code);
        LOGGER.info("END");
        return country;
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START");
        Country savedCountry = countryService.addCountry(country);
        LOGGER.info("END");
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @PutMapping
    public Country updateCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START");
        Country updatedCountry = countryService.updateCountry(country);
        LOGGER.info("END");
        return updatedCountry;
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        LOGGER.info("START");
        countryService.deleteCountry(code);
        LOGGER.info("END");
        return ResponseEntity.noContent().build();
    }
}