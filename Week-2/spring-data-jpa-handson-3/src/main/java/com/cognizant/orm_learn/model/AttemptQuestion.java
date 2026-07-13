package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "attempt_question")
@Getter
@Setter
@ToString
public class AttemptQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "aq_at_id")
    @ToString.Exclude
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qt_id")
    @ToString.Exclude
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion")
    @ToString.Exclude
    private Set<AttemptOption> attemptOptionList;

}