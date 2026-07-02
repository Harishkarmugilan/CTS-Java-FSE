package com.example.employeemanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.projection.EmployeeNameOnly;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    List<EmployeeNameOnly> findAllProjectedBy();

    Page<Employee> findByDepartment_Name(String departmentName, Pageable pageable);

    @Query("select e from Employee e where e.department.name = :departmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    List<Employee> findByDepartmentNameNamedQuery(@Param("departmentName") String departmentName);
}
