package com.springboot_security.springBootSecurity.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String role;

    public customer() {
    }

    public customer(String email, String pwd, String role) {
        this.email = email;
        this.pwd = pwd;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
