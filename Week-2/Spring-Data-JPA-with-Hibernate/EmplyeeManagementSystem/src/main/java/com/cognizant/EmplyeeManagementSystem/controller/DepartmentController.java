package com.cognizant.EmplyeeManagementSystem.controller;

import com.cognizant.EmplyeeManagementSystem.model.Department;
import com.cognizant.EmplyeeManagementSystem.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        return service.getDepartment(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department department) {
        return service.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        service.deleteDepartment(id);
    }
}