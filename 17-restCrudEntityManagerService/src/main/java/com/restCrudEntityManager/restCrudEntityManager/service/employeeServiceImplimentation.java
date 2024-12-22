package com.restCrudEntityManager.restCrudEntityManager.service;
import com.restCrudEntityManager.restCrudEntityManager.dao.employeeDao;
import com.restCrudEntityManager.restCrudEntityManager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class employeeServiceImplimentation implements emplyeeService{
    private employeeDao employeeDao;

    @Autowired
    public employeeServiceImplimentation(employeeDao myEmployeeDao){
        employeeDao=myEmployeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public void add(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(int id){
        employeeDao.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }
}
