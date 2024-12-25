package com.spring_crud_jpa.spring_crud_jpa.service;

import com.spring_crud_jpa.spring_crud_jpa.model.Employee;

import java.util.List;

public interface employeeService {
    void add(Employee employee);
    List<Employee> all();
    void delete(int id);

    void update(Employee employee);

    Employee searchN(String name);
}
