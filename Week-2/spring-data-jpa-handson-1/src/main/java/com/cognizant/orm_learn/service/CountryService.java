package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // 1. Find country by code
    @Transactional
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result =
                countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException();
        }

        Country country = result.get();

        return country;
    }

    // 2. Add new country
    @Transactional
    public void addCountry(Country country){
        countryRepository.save(country);
    }


    // 3. Update country
    @Transactional
    public void updateCountry(String code, String name)
            throws CountryNotFoundException {

        Optional<Country> result =
                countryRepository.findById(code);

        if (!result.isPresent()) {
            throw new CountryNotFoundException();
        }

        Country country = result.get();

        country.setName(name);

        countryRepository.save(country);
    }

    // 4. Delete country
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // 5. Search by partial country name
    @Transactional
    public List<Country> searchCountry(String name) {
        return countryRepository.findByNameContaining(name);
    }
}