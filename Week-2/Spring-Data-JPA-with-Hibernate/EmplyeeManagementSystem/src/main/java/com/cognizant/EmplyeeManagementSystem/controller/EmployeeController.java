package com.cognizant.EmplyeeManagementSystem.controller;

import com.cognizant.EmplyeeManagementSystem.model.Employee;
import com.cognizant.EmplyeeManagementSystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return service.getEmployee(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
    }

    @GetMapping("/page")
    public Page<Employee> getEmployees(
            @RequestParam int page,
            @RequestParam int size) {

        return service.getEmployees(page, size);
    }

    @GetMapping("/sort")
    public List<Employee> sortEmployees() {
        return service.getSortedEmployees();
    }
}