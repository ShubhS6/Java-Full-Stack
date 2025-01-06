package com.hibernate_oneToone.hibernate_oneToone.dao;

import com.hibernate_oneToone.hibernate_oneToone.model.InstructorDetail;
import com.hibernate_oneToone.hibernate_oneToone.model.instructor;

public interface instructorDao {
    void save(instructor instructor);
    instructor findById(int id);
    void deleteById(int id);
    InstructorDetail findInstructorDetailByid(int id);
}
