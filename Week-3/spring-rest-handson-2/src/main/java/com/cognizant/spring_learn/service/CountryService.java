package com.cognizant.spring_learn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryService.class);

    private static final ApplicationContext context =
            new ClassPathXmlApplicationContext("country.xml");

    public Country getCountry(String code)
            throws CountryNotFoundException {

        LOGGER.info("START");

        List<Country> countryList =
                context.getBean("countryList", List.class);

        for (Country country : countryList) {

            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.debug("Country: {}", country);
                LOGGER.info("END");

                return country;
            }
        }

        LOGGER.info("END");

        throw new CountryNotFoundException();
    }
}