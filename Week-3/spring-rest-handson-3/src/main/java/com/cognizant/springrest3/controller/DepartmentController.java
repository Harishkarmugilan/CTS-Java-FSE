package com.cognizant.springrest3.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest3.model.Department;
import com.cognizant.springrest3.service.DepartmentService;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService = new DepartmentService();

    @GetMapping("/departments")
    public ArrayList<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}