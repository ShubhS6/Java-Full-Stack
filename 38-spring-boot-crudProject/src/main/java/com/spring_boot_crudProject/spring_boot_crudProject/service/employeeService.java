package com.spring_boot_crudProject.spring_boot_crudProject.service;

import com.spring_boot_crudProject.spring_boot_crudProject.model.employee;

import java.util.List;

public interface employeeService {
    List<employee> findAll();
    employee findById(int id);
    String save(employee employee);
    String deleteById(int id);
}
