package com.cognizant.spring_learn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.service.DepartmentService;

@RestController
public class DepartmentController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public ArrayList<Department> getAllDepartments() {

        LOGGER.info("START");

        ArrayList<Department> departmentList =
                departmentService.getAllDepartments();

        LOGGER.info("END");

        return departmentList;
    }
}