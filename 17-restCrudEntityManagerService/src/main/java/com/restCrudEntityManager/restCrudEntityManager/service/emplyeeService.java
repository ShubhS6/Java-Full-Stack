package com.restCrudEntityManager.restCrudEntityManager.service;

import com.restCrudEntityManager.restCrudEntityManager.model.Employee;

import java.util.List;

public interface emplyeeService {
    List<Employee> getAll();
    Employee getById(int id);

    void add(Employee employee);

    void delete(int id);

    void update(Employee employee);
}
