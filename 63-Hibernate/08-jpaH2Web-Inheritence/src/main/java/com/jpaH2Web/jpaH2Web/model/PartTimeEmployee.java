package com.jpaH2Web.jpaH2Web.model;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{

    public PartTimeEmployee() {
    }

    private int salary;

    public PartTimeEmployee(int id, String name,int salary) {
        super(id, name);
        this.salary=salary;
    }
}
