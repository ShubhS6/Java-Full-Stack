package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import com.jpaH2Web.jpaH2Web.model.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    @Autowired
    private EntityManager em;

    @Transactional
    public String addData(){
        Review r1=new Review(5004,"3","great course I love it");
        Review r2=new Review(5005,"1","not that great");
        em.persist(r1);
        em.persist(r2);
        Course c=em.find(Course.class,10001);
        c.setReviews(List.of(r1,r2));
        r1.setCourse(c);
        r2.setCourse(c);
        em.persist(c);
        em.persist(r1);
        em.persist(r2);
        return "data Saved successfully";
    }
}
