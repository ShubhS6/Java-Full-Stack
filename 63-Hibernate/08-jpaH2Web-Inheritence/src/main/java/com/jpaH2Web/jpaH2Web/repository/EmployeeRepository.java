package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Employee;
import com.jpaH2Web.jpaH2Web.model.FullTimeEmployee;
import com.jpaH2Web.jpaH2Web.model.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Transactional
@Repository
public class EmployeeRepository {
    @Autowired
    private EntityManager entityManager;


    @Transactional
    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    //It is not for Mapped query
    /*
    @Transactional
    public List<Employee> findAll(){
        return entityManager.createQuery("select e from Employee e").getResultList();
    }
     */

    //It is for mapped query

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
        return entityManager.createQuery("select e from PartTimeEmployee e").getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        return entityManager.createQuery("select e from FullTimeEmployee e").getResultList();
    }

}
