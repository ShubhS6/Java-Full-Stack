package com.spring_boot_crudProject.spring_boot_crudProject.repository;

import com.spring_boot_crudProject.spring_boot_crudProject.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employee,Integer> {
}
