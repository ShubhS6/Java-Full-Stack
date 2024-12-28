package com.spring_boot_crudProject.spring_boot_crudProject.service;

import com.spring_boot_crudProject.spring_boot_crudProject.model.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring_boot_crudProject.spring_boot_crudProject.repository.employeeRepository;

import java.util.List;
@Service
public class employeeServiceImpliment implements employeeService{
    private employeeRepository employeeRepository;

    @Autowired
    public employeeServiceImpliment(employeeRepository theemployeeRepository){
        employeeRepository=theemployeeRepository;
    }

    @Override
    public List<employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public String save(employee employee) {
        employeeRepository.save(employee);
        return "data saved successfully";
    }

    @Override
    public String deleteById(int id) {
        employeeRepository.deleteById(id);
        return "data deleted successfully";
    }
}
