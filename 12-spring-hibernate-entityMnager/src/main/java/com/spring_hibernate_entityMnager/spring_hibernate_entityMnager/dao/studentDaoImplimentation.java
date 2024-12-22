package com.spring_hibernate_entityMnager.spring_hibernate_entityMnager.dao;

import com.spring_hibernate_entityMnager.spring_hibernate_entityMnager.madel.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class studentDaoImplimentation implements studentDao{
    private EntityManager entityManager;

    @Autowired
    public studentDaoImplimentation(EntityManager myEntityManager){
        entityManager=myEntityManager;
    }

    @Override
    @Transactional
    public void save(student student) {
        entityManager.persist(student);
    }

    @Override
    public student findById(int id) {
        return entityManager.find(student.class,id);
    }

    @Override
    public List<student> allStudent() {
        TypedQuery<student> theQuery=entityManager.createQuery("FROM student",student.class);
        List<student> ans=theQuery.getResultList();
        return ans;
    }

    @Override
    public List<student> findByLastName(String LastName) {
        TypedQuery<student> theQuery=entityManager.createQuery("FROM student WHERE lastName=:theData",student.class);
        theQuery.setParameter("theData",LastName);
        List<student> ans=theQuery.getResultList();
        return ans;
    }

    @Override
    @Transactional
    public void updateStudent(student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateLastName(String last) {
        entityManager.createQuery("UPDATE student SET lastName='test'").executeUpdate();
    }

    @Override
    @Transactional
    public void delete(int id) {
        student st=entityManager.find(student.class,id);
        entityManager.remove(st);
    }
}
