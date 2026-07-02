package com.example.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.projection.EmployeeNameOnly;
import com.example.employeemanagement.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<EmployeeNameOnly> findAllProjected() {
        return employeeRepository.findAllProjectedBy();
    }

    @Transactional(readOnly = true)
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    @Transactional(readOnly = true)
    public Page<Employee> findByDepartment(String departmentName, Pageable pageable) {
        return employeeRepository.findByDepartment_Name(departmentName, pageable);
    }

    @Transactional(readOnly = true)
    public List<Employee> findByDepartmentNameNamedQuery(String departmentName) {
        return employeeRepository.findByDepartmentNameNamedQuery(departmentName);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
