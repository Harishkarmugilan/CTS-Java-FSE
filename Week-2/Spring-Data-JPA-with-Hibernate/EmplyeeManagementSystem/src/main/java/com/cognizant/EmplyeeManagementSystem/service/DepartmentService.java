package com.cognizant.EmplyeeManagementSystem.service;

import com.cognizant.EmplyeeManagementSystem.model.Department;
import com.cognizant.EmplyeeManagementSystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartment(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    public Department updateDepartment(Department department) {
        return repository.save(department);
    }

    public void deleteDepartment(Integer id) {
        repository.deleteById(id);
    }

}