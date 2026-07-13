package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "options")
@Getter
@Setter
@ToString
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text")
    private String text;

    @Column(name = "op_score")
    private double score;

    @ManyToOne
    @JoinColumn(name = "op_qt_id")
    @ToString.Exclude
    private Question question;

    @OneToMany(mappedBy = "option")
    @ToString.Exclude
    private Set<AttemptOption> attemptOptionList;

}