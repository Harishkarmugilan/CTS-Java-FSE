package com.cognizant.EmplyeeManagementSystem.repository;

import com.cognizant.EmplyeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByName(String name);

    List<Department> findByNameContaining(String keyword);

    @Query("SELECT d FROM Department d")
    List<Department> getAllDepartments();

}