package com.hibernateOneToMany.hibernateOneToMany.dao;

import com.hibernateOneToMany.hibernateOneToMany.model.course;
import com.hibernateOneToMany.hibernateOneToMany.model.instructor;
import org.springframework.stereotype.Repository;

public interface mainDao {
    void save(instructor instructor);
    instructor findById(int id);
    void update(instructor instructor);
    instructor findinstructorByjoinFetch(int id);
    void addReview(course course);
    course findCourseById(int id);
}
