package com.spring_hibernate_entityMnager.spring_hibernate_entityMnager.dao;

import com.spring_hibernate_entityMnager.spring_hibernate_entityMnager.madel.student;

import java.util.List;

public interface studentDao {
    void save(student student);
    student findById(int id);

    List<student> allStudent();
    List<student> findByLastName(String LastName);

    void updateStudent(student student);

    void updateLastName(String last);

    void delete(int id);

}
