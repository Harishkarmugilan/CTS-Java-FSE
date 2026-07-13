package com.cognizant.EmplyeeManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmplyeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmplyeeManagementSystemApplication.class, args);
	}
}
