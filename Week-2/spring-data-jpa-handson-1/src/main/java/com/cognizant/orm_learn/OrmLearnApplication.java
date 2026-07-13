package com.cognizant.orm_learn;

import java.util.List;

import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args)
			throws CountryNotFoundException {

		ApplicationContext context =
				SpringApplication.run(OrmLearnApplication.class, args);

		countryService =
				context.getBean(CountryService.class);
		testAddCountry("AT","ATLANTIC");
		testUpdateCountry("AT","Atlantis");
		testDeleteCountry("AT");
	}

	private static void testAddCountry(String code,String cname)
			throws CountryNotFoundException {

		LOGGER.info("ADD Start");

		// Create new Country object
		Country country = new Country();

		country.setCode(code);
		country.setName(cname);

		// Save to database
		countryService.addCountry(country);

		// Retrieve it again to check whether it was saved
		Country result =
				countryService.findCountryByCode(code);

		LOGGER.debug("Added Country = {}", result);

		LOGGER.info("End");
	}
	private static void testUpdateCountry(String code,String cname)
			throws CountryNotFoundException {

		LOGGER.info("Update Start");

		countryService.updateCountry(code, cname);

		Country country =
				countryService.findCountryByCode(code);

		LOGGER.debug("Updated Country = {}", country);

		LOGGER.info("End");
	}
	private static void testDeleteCountry(String code) {

		LOGGER.info("Delete Start");

		countryService.deleteCountry(code);

		LOGGER.debug("Country with code " + code+" deleted");

		LOGGER.info("End");
	}
}