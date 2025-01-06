package com.hibernate_oneToone.hibernate_oneToone.dao;

import com.hibernate_oneToone.hibernate_oneToone.model.instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class instructorDaoImpliment implements instructorDao{

    private EntityManager entityManager;

    @Autowired
    public instructorDaoImpliment(EntityManager myentityManager){
        entityManager=myentityManager;
    }

    @Override
    @Transactional
    public void save(instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public instructor findById(int id) {
        return entityManager.find(instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructor inst=entityManager.find(instructor.class,id);
        entityManager.remove(inst);
    }
}
