package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws Exception {

		SpringApplication.run(SpringLearnApplication.class, args);

		displayDate();
		displayCountry();
		displayCountries();
	}

	public static void displayCountry() {

		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("in", Country.class);
		Country anothercountry = context.getBean("in",Country.class);

		LOGGER.info	("Country : {}", country.toString());
		LOGGER.info	("Country : {}", (anothercountry==country));

		LOGGER.info("END");
	}

	public static void displayDate() throws Exception {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format =
				context.getBean("dateFormat", SimpleDateFormat.class);

		Date date = format.parse("31/12/2018");

		LOGGER.info("START");
		LOGGER.info("Date: {}", date);
		LOGGER.info("END");

	}

	public static void displayCountries() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> countryList =
				context.getBean("countryList", ArrayList.class);

		LOGGER.info("Country List : {}", countryList);

		LOGGER.info("END");
	}
}