package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public com.cognizant.orm_learn.model.Skill get(int id) {

        return skillRepository.findById(id).get();
    }

    @Transactional
    public void save(com.cognizant.orm_learn.model.Skill skill) {

        skillRepository.save(skill);
    }
}