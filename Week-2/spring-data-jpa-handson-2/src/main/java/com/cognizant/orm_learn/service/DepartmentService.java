package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public com.cognizant.orm_learn.model.Department get(int id) {

        return departmentRepository.findById(id).get();
    }

    @Transactional
    public void save(com.cognizant.orm_learn.model.Department department) {

        departmentRepository.save(department);
    }
}