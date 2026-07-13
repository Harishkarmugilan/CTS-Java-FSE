package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "attempt_option")
@Getter
@Setter
@ToString
public class AttemptOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id")
    private int id;

    @Column(name = "ao_selected")
    private boolean selected;

    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    @ToString.Exclude
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    @ToString.Exclude
    private Option option;

}