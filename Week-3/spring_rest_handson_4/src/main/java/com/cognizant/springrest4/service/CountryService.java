package com.cognizant.springrest4.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.springrest4.model.Country;

@Service
public class CountryService {

    private final Map<String, Country> countries = new LinkedHashMap<>();

    public CountryService() {
        countries.put("US", new Country("US", "United States", "Washington"));
        countries.put("DE", new Country("DE", "Germany", "Berlin"));
        countries.put("IN", new Country("IN", "India", "New Delhi"));
        countries.put("JP", new Country("JP", "Japan", "Tokyo"));
    }

    public List<Country> getAllCountries() {
        return new ArrayList<>(countries.values());
    }

    public Country getCountry(String code) {
        return countries.get(code.toUpperCase());
    }

    public Country addCountry(Country country) {
        countries.put(country.getCode().toUpperCase(), country);
        return country;
    }

    public Country updateCountry(Country country) {
        countries.put(country.getCode().toUpperCase(), country);
        return country;
    }

    public void deleteCountry(String code) {
        countries.remove(code.toUpperCase());
    }

    public boolean exists(String code) {
        return Optional.ofNullable(countries.get(code.toUpperCase())).isPresent();
    }
}