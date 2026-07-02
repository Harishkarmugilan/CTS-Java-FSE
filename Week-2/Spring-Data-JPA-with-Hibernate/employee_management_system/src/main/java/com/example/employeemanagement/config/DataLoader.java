package com.example.employeemanagement.config;

import com.example.employeemanagement.domain.Department;
import com.example.employeemanagement.domain.Employee;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        return args -> {
            Department engineering = new Department();
            engineering.setName("Engineering");
            departmentRepository.save(engineering);

            Department hr = new Department();
            hr.setName("HR");
            departmentRepository.save(hr);

            Employee employee = new Employee();
            employee.setFirstName("Asha");
            employee.setLastName("Patel");
            employee.setEmail("asha.patel@example.com");
            employee.setDepartment(engineering);
            employeeRepository.save(employee);
        };
    }
}
