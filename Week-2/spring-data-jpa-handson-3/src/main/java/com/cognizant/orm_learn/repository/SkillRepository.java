package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository
        extends JpaRepository<com.cognizant.orm_learn.model.Skill, Integer> {
}