package com.springboot_security.springBootSecurity.controller;

import com.springboot_security.springBootSecurity.model.customer;
import com.springboot_security.springBootSecurity.repository.crudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController {
    private crudRepository crudRepository;
    private PasswordEncoder passwordEncoder;

    public customerController(com.springboot_security.springBootSecurity.repository.crudRepository crudRepository, PasswordEncoder passwordEncoder) {
        this.crudRepository = crudRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody customer customer){
        try {
            String hashPassword=passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPassword);
            customer saveCustomer=crudRepository.save(customer);
            if (saveCustomer.getId()>0){
                return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Registration failed");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured"+e.getMessage());
        }
    }
}
