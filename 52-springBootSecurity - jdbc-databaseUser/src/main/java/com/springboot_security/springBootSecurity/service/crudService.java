package com.springboot_security.springBootSecurity.service;

import com.springboot_security.springBootSecurity.model.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springboot_security.springBootSecurity.repository.crudRepository;

import java.util.List;

@Service
public class crudService implements UserDetailsService {
    @Autowired
    private final crudRepository crudRepository;

    public crudService(com.springboot_security.springBootSecurity.repository.crudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        customer customer=crudRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
        List<GrantedAuthority> authorityList=List.of(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getEmail(), customer.getPwd(), authorityList);
    }
}
