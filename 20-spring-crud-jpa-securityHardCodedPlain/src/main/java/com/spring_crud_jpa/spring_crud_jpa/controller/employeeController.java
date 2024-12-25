package com.spring_crud_jpa.spring_crud_jpa.controller;
import com.spring_crud_jpa.spring_crud_jpa.service.employeeService;
import com.spring_crud_jpa.spring_crud_jpa.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {

    private employeeService employeeService;

    @Autowired
    public employeeController(employeeService myemployeeService) {
        employeeService = myemployeeService;
    }

    @GetMapping("/all")
    public List<Employee> all(){
        return employeeService.all();
    }

    @PostMapping("/save")
    public String save(@RequestBody Employee employee){
        employeeService.add(employee);
        return "data saved successfully";
    }

    @PutMapping("/update")
    public String update(@RequestBody Employee employee){
        employeeService.update(employee);
        return "data updated successfully";
    }



    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "data deleted successfully";
    }

    @GetMapping("/searchName")
    public Employee find(@RequestParam(required = false) String name){
        return employeeService.searchN(name);
    }
}
