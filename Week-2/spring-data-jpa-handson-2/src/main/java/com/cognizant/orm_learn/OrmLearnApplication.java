package com.cognizant.orm_learn;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.*;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static StockService stockService;

	private static EmployeeService employeeService;

	private static DepartmentService departmentService;

	private static SkillService skillService;

	public static void main(String[] args)
			throws CountryNotFoundException {

		ApplicationContext context =
				SpringApplication.run(OrmLearnApplication.class, args);

		countryService =
				context.getBean(CountryService.class);
		stockService =
				context.getBean(StockService.class);

		employeeService =
				context.getBean(EmployeeService.class);

		departmentService =
				context.getBean(DepartmentService.class);

		skillService =
				context.getBean(SkillService.class);
		// Country test methods
//		testAddCountry("AT","ATLANTIC");
//		testUpdateCountry("AT","Atlantis");
//		testDeleteCountry("AT");

//		testSearchCountry("ou");
//		testSearchCountryAsc("ou");
//		testSearchCountryDesc("ou");
//		testSearchCountryByAlphabet("z");

		// Stocks Test methods
//		TestGetStocksByDate("FB",
//				LocalDate.of(2019, 9, 1),
//				LocalDate.of(2019, 9, 30));
//		testfindByCodeAndCloseGreaterThan("GOOGL",(double) 1250);
//		testfindTop3ByCodeOrderByCloseAsc("NFLX");

		// Employee Test methods

		testAddEmployee();
		testUpdateEmployee();
		testGetEmployee();
		testGetDepartment();


	}

	// Employees
	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);

		LOGGER.debug("Employee: {}", employee);

		LOGGER.debug("Department: {}", employee.getDepartment());

		LOGGER.debug("Skills: {}", employee.getSkillList());

		LOGGER.info("End");
	}

	private static void testAddEmployee() {

		LOGGER.info("Start");

		Employee employee = new Employee();

		employee.setName("Harish");
		employee.setSalary(50000);
		employee.setPermanent(true);

		com.cognizant.orm_learn.model.Department department =
				departmentService.get(1);

		employee.setDepartment(department);

		employeeService.save(employee);

		LOGGER.debug("Employee: {}", employee);

		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {

		LOGGER.info("Start");

		Employee employee =
				employeeService.get(1);

		com.cognizant.orm_learn.model.Department department =
				departmentService.get(2);

		employee.setDepartment(department);

		employeeService.save(employee);

		LOGGER.debug("Employee: {}", employee);

		LOGGER.info("End");
	}

	private static void testGetDepartment() {

		LOGGER.info("Start");

		Department department =
				departmentService.get(1);

		LOGGER.debug("Department: {}", department);

		LOGGER.debug("Employees: {}",
				department.getEmployeeList());

		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {

		LOGGER.info("Start");

		// Get existing employee
		Employee employee = employeeService.get(1);

		// Get existing skill
		Skill skill = skillService.get(2);

		// Add skill to employee's skill list
		employee.getSkillList().add(skill);

		// Save employee
		employeeService.save(employee);

		LOGGER.debug("Employee: {}", employee);
		LOGGER.debug("Skills: {}", employee.getSkillList());

		LOGGER.info("End");
	}



	// Stocks

	private static void testfindTop3ByCodeOrderByCloseAsc(String code){
		LOGGER.info("findTop3ByCodeOrderByCloseAsc Start");

		List<Stock> stocks =
				stockService.findTop3ByCodeOrderByCloseAsc(code);

		LOGGER.debug("Stocks = {}", stocks);

		LOGGER.info("END");
	}


	private static void testfindByCodeAndCloseGreaterThan(String code, double close){
		LOGGER.info("findByCodeAndCloseGreaterThan Start");

		List<Stock> stocks =
				stockService.findByCodeAndCloseGreaterThan(code,close);

		LOGGER.debug("Stocks = {}", stocks);

		LOGGER.info("END");
	}

	private static void TestGetStocksByDate(String code, LocalDate startDate, LocalDate endDate) {

		LOGGER.info("Stock Search by Date Start");

		List<Stock> stocks = stockService.getStocksByDate(code,startDate,endDate);


		LOGGER.debug("Stocks = {}", stocks);

		LOGGER.info("End");
	}

	// Country

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
	 private static void testSearchCountry(String partial_word){
		 LOGGER.info("Search by partial name Start");

		 List<Country> countries =
				 countryService.searchCountry(partial_word);

		 LOGGER.debug("Countries = {}", countries);

		 LOGGER.info("END");
	 }
	private static void testSearchCountryAsc(String partial_word){
		LOGGER.info("Search by partial name Ascending order Start");

		List<Country> countries =
				countryService.searchCountryAscending(partial_word);

		LOGGER.debug("Countries = {}", countries);

		LOGGER.info("END");
	}

	private static void testSearchCountryDesc(String partial_word){
		LOGGER.info("Search by partial name Descending order Start");

		List<Country> countries =
				countryService.searchCountryDescending(partial_word);

		LOGGER.debug("Countries = {}", countries);

		LOGGER.info("END");
	}

	private static void testSearchCountryByAlphabet(String Alphabet){
		LOGGER.info("Search by Alphabet Start");

		List<Country> countries =
				countryService.searchCountryByAlphabet(Alphabet);

		LOGGER.debug("Countries = {}", countries);

		LOGGER.info("END");
	}


}