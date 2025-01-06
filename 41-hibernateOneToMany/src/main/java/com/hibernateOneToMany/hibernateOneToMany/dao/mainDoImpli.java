package com.hibernateOneToMany.hibernateOneToMany.dao;

import com.hibernateOneToMany.hibernateOneToMany.model.instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class mainDoImpli implements mainDao {
    private EntityManager entityManager;
    @Autowired
    public mainDoImpli(EntityManager myentityManager){
        entityManager=myentityManager;
    }

    @Override
    @Transactional
    public void save(instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public instructor findById(int id) {
        return entityManager.find(instructor.class,id);
    }

    @Override
    @Transactional
    public void update(instructor instructor) {
         entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public instructor findinstructorByjoinFetch(int id) {
        TypedQuery<instructor> query=entityManager.createQuery("SELECT i FROM instructor i "+
                                                                    "JOIN FETCH i.courseList "+"JOIN FETCH i.instructorDetail "+
                                                                    "WHERE i.id = :data", instructor.class);
        query.setParameter("data",id);
        instructor instructor=query.getSingleResult();
        return instructor;
    }


}
