package com.restCrudEntityManager.restCrudEntityManager.dao;

import com.restCrudEntityManager.restCrudEntityManager.model.Employee;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

public interface employeeDao {
    List<Employee> findAll();
}
