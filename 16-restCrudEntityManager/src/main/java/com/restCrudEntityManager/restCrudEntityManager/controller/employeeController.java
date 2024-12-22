package com.restCrudEntityManager.restCrudEntityManager.controller;

import com.restCrudEntityManager.restCrudEntityManager.dao.employeeDao;
import com.restCrudEntityManager.restCrudEntityManager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {

    private employeeDao employeeDao;

    @Autowired
    public employeeController(employeeDao myEmployeeDao){
            employeeDao=myEmployeeDao;
    }

    @GetMapping("/all")
    public List<Employee> all(){
        return employeeDao.findAll();
    }
}
