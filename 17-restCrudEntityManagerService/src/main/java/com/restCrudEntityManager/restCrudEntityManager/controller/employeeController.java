package com.restCrudEntityManager.restCrudEntityManager.controller;

import com.restCrudEntityManager.restCrudEntityManager.dao.employeeDao;
import com.restCrudEntityManager.restCrudEntityManager.model.Employee;
import com.restCrudEntityManager.restCrudEntityManager.service.emplyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {

    private emplyeeService employeeService;

    @Autowired
    public employeeController(emplyeeService myEmployeeService){
            employeeService=myEmployeeService;
    }

    @GetMapping("/all")
    public List<Employee> all(){
        return employeeService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Employee getById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Employee e){
        employeeService.add(e);
        return "Saved the data";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "data deleted successfully";
    }

    @PutMapping("/update")
    public String update(@RequestBody Employee e){
        employeeService.add(e);
        return "data updated";
    }
}
