package com.cognizant.EmplyeeManagementSystem.service;

import com.cognizant.EmplyeeManagementSystem.model.Employee;
import com.cognizant.EmplyeeManagementSystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }

    public Page<Employee> getEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public List<Employee> getSortedEmployees() {

        return repository.findAll(
                Sort.by("name")
        );

    }
}