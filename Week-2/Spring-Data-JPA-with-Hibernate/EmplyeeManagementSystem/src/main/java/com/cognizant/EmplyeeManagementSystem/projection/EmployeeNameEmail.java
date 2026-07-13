package com.cognizant.EmplyeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameEmail {

    @Value("#{target.name + ' - ' + target.email}")
    String getEmployeeInfo();

}