package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "question")
@Getter
@Setter
@ToString
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qt_id")
    private int id;

    @Column(name = "qt_text")
    private String text;

    @OneToMany(mappedBy = "question")
    @ToString.Exclude
    private Set<Option> optionList;

    @OneToMany(mappedBy = "question")
    @ToString.Exclude
    private Set<AttemptQuestion> attemptQuestionList;

}