package com.cognizant.springrest3.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest3.model.Employee;
import com.cognizant.springrest3.service.EmployeeService;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService = new EmployeeService();

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}