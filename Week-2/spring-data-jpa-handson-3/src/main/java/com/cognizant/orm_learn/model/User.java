package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private int id;

    @Column(name = "us_name")
    private String name;

    @Column(name = "us_email")
    private String email;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Attempt> attemptList;

}