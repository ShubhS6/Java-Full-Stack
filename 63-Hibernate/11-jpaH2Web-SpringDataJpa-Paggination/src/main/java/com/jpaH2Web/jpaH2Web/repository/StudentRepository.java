package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Passport;
import com.jpaH2Web.jpaH2Web.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @Autowired
    private EntityManager em;

    @Transactional
    public void save(){
        Passport passport=new Passport(4004,"S232113");
        em.persist(passport);
        Student student=new Student(2004,"Ana");
        student.setPassport(passport);
        em.persist(student);
    }

    @Transactional
    public Student findById(int id){
        return em.find(Student.class,id);
    }
}
