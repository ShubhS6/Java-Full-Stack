package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public class CourseSpringDataRepositoryTest {
    @Autowired
    private CourseSpringDataRepository csdr;

    public void findById() {
        Optional<Course> c=csdr.findById(10001);
        System.out.println(c);
    }

}
