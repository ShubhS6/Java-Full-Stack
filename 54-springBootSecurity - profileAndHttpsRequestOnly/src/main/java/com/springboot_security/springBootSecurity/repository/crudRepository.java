package com.springboot_security.springBootSecurity.repository;

import com.springboot_security.springBootSecurity.model.customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@Repository
public interface crudRepository extends CrudRepository<customer, Integer> {
    Optional<customer> findByEmail(String s);
}
