package com.cognizant.EmplyeeManagementSystem.model;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

import jakarta.persistence.EntityListeners;

import java.time.LocalDateTime;
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(
                name = "Employee.findByEmail",
                query = "SELECT e FROM Employee e WHERE e.email = :email"
        ),
        @NamedQuery(
                name = "Employee.findAllEmployees",
                query = "SELECT e FROM Employee e"
        )
})
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id")
    private Integer id;

    @Column(name = "em_name")
    private String name;

    @Column(name = "em_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}