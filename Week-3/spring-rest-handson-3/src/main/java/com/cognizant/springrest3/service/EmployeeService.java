package com.cognizant.springrest3.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springrest3.dao.EmployeeDao;
import com.cognizant.springrest3.model.Employee;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Transactional
    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("START");
        ArrayList<Employee> employees = employeeDao.getAllEmployees();
        LOGGER.info("END");
        return employees;
    }
}