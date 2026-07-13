package com.cognizant.EmplyeeManagementSystem.repository;

import com.cognizant.EmplyeeManagementSystem.dto.EmployeeDTO;
import com.cognizant.EmplyeeManagementSystem.model.Employee;
import com.cognizant.EmplyeeManagementSystem.projection.EmployeeNameEmail;
import com.cognizant.EmplyeeManagementSystem.projection.EmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Derived Query Methods

    List<Employee> findByName(String name);

    Employee findByEmail(String email);

    List<Employee> findByNameContaining(String keyword);

//    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> findByNameEndingWith(String suffix);

    List<Employee> findByNameIgnoreCase(String name);

    List<EmployeeView> findByDepartmentName(String name);

    @Query("""
SELECT new com.cognizant.EmplyeeManagementSystem.dto.EmployeeDTO(
e.name,
e.email)
FROM Employee e
""")
    List<EmployeeDTO> getEmployees();
    // JPQL Query

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee getEmployeeByEmail(@Param("email") String email);


    @Query("SELECT e FROM Employee e WHERE e.department.name = :department")
    List<Employee> getEmployeesByDepartment(@Param("department") String department);


    // Native SQL Query

    @Query(value = "SELECT * FROM employee WHERE name = :name", nativeQuery = true)
    List<Employee> getEmployeeByNameNative(@Param("name") String name);


    // Named Query

    @Query(name = "Employee.findByEmail")
    Employee findEmployeeUsingNamedQuery(@Param("email") String email);

    List<EmployeeNameEmail> findAllProjectedBy();

}