package com.cognizant.springrest3.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springrest3.dao.DepartmentDao;
import com.cognizant.springrest3.model.Department;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentDao departmentDao = new DepartmentDao();

    @Transactional
    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("START");
        ArrayList<Department> departments = departmentDao.getAllDepartments();
        LOGGER.info("END");
        return departments;
    }
}