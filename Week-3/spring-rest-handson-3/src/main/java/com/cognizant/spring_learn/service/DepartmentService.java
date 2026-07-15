package com.cognizant.spring_learn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.dao.DepartmentDao;
import com.cognizant.spring_learn.model.Department;

@Service
public class DepartmentService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public ArrayList<Department> getAllDepartments() {

        LOGGER.info("START");

        ArrayList<Department> departmentList =
                departmentDao.getAllDepartments();

        LOGGER.info("END");

        return departmentList;
    }
}