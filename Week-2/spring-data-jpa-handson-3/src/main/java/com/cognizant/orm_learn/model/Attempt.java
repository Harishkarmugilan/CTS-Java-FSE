package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "attempt")
@Getter
@Setter
@ToString
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "at_score")
    private double score;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "attempt")
    @ToString.Exclude
    private Set<AttemptQuestion> attemptQuestionList;

}