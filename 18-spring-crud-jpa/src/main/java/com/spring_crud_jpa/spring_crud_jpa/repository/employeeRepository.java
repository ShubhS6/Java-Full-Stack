package com.spring_crud_jpa.spring_crud_jpa.repository;

import com.spring_crud_jpa.spring_crud_jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<Employee,Integer> {
    @Query("SELECT e FROM Employee e WHERE "+("e.firstName=?1"))
    Employee findByName(String name);
}
