package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class NPlusOneRepository {
    @Autowired
    private EntityManager e;

    //problem n+1 problem
    @Transactional
    public void data(){
        List<Course> course=e.createQuery("Select c from Course c", Course.class).getResultList();
        for(Course c:course){
            System.out.println(c.getStudents());
        }
    }



    //Solution of n+1 Problem
    @Transactional
    public void dataSolution(){
        EntityGraph<Course> courseEntityGraph=e.createEntityGraph(Course.class);
        Subgraph<Object> subgraph =courseEntityGraph.addSubgraph("students");
        List<Course> course=e.createQuery("Select c from Course c", Course.class)
                .setHint("javax.persistence.loadgraph",courseEntityGraph)
                .getResultList();
        for(Course c:course){
            System.out.println(c.getStudents());
        }
    }


    //one more solution
    @Transactional
    public void dataSolutionOneMore(){
        List<Course> course=e.createQuery("Select c from Course c JOIN FETCH c.students", Course.class).getResultList();
        for(Course c:course){
            System.out.println(c.getStudents());
        }
    }
}
