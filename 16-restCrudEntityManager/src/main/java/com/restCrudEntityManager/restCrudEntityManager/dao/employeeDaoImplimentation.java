package com.restCrudEntityManager.restCrudEntityManager.dao;

import com.restCrudEntityManager.restCrudEntityManager.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class employeeDaoImplimentation implements employeeDao{
    private EntityManager entityManager;

    @Autowired
    public employeeDaoImplimentation(EntityManager myEntityManager){
        entityManager=myEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query= entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees=query.getResultList();
        return employees;
    }
}
