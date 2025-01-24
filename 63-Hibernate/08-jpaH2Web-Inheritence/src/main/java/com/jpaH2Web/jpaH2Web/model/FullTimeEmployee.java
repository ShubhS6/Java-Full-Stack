package com.jpaH2Web.jpaH2Web.model;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    public FullTimeEmployee() {
    }

    private int Salary;

    public FullTimeEmployee(int id, String name, int salary) {
        super(id, name);
        this.Salary = salary;
    }
}
