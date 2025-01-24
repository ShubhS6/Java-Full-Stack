package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseRepository {
    @Autowired
    EntityManager em;

    public Course findById(int id){
        return em.find(Course.class, id);
    }

    @Transactional
    public String deleteById(int id){
        Course course=em.find(Course.class, id);
        em.remove(course);
        return "Data Deleted";
    }

    public List<Course> showAll(){
        TypedQuery<Course> query =em.createQuery("select c from Course c",Course.class);
        return query.getResultList();
    }

    @Transactional
    public String save(Course course){
        em.persist(course);
        return "Data Saved";
    }

    public List<Course> search(){
        TypedQuery<Course> c= em.createQuery("select c from Course c where name like '%N'", Course.class);
        return c.getResultList();
    }
}
