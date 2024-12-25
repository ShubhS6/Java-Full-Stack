package com.spring_crud_jpa.spring_crud_jpa.service;
import com.spring_crud_jpa.spring_crud_jpa.security.InvalidIdException;
import com.spring_crud_jpa.spring_crud_jpa.security.nameNotFound;
import com.spring_crud_jpa.spring_crud_jpa.repository.employeeRepository;
import com.spring_crud_jpa.spring_crud_jpa.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeServiceImplimentation implements employeeService{

    private employeeRepository employeeRepository;

    @Autowired
    public employeeServiceImplimentation(employeeRepository myEmployeeRepository){
        employeeRepository=myEmployeeRepository;
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> all() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(int id) {
        int count=(int)employeeRepository.count();
        if(id>count||id<0){
            throw new InvalidIdException("Invalid Id "+id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee searchN(String name) {
        Employee em=employeeRepository.findByName(name);
        if(em==null){
            throw new nameNotFound("Name is not there plz enter valid name");
        }
        return em;
    }

}
