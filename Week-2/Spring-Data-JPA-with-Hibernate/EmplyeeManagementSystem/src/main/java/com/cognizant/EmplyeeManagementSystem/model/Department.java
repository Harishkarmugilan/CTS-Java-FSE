package com.cognizant.EmplyeeManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dp_id")
    private Integer id;

    @Column(name = "dp_name")
    private String name;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<Employee> employees;

}