package com.example.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagement.domain.Department;
import com.example.employeemanagement.projection.DepartmentNameOnly;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByNameContainingIgnoreCase(String name);

    List<DepartmentNameOnly> findAllProjectedBy();
}
