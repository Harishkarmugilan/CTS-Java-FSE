package com.cognizant.spring_learn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    private final List<Country> countryList =
            context.getBean("countryList", List.class);


    public List<Country> getAllCountries() {

        return countryList;
    }


    public Country getCountry(String code)
            throws CountryNotFoundException {

        for (Country country : countryList) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException();
    }


    public Country addCountry(Country country) {

        countryList.add(country);

        return country;
    }


    public Country updateCountry(Country updatedCountry)
            throws CountryNotFoundException {

        for (int i = 0; i < countryList.size(); i++) {

            Country country = countryList.get(i);

            if (country.getCode()
                    .equalsIgnoreCase(updatedCountry.getCode())) {

                countryList.set(i, updatedCountry);

                return updatedCountry;
            }
        }

        throw new CountryNotFoundException();
    }


    public void deleteCountry(String code)
            throws CountryNotFoundException {

        Country country = getCountry(code);

        countryList.remove(country);
    }
}