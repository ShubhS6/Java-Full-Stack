package com.spring_boot_crudProject.spring_boot_crudProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee")
public class employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    @NotNull(message = "is required")
    @Size(min=4,message = "Min 4 letter required")
    private String firstName;
    @Column(name = "last_name")
    @NotNull(message = "is required")
    @Size(min=4,message = "Min 4 letter required")
    private String lastName;
    @Column(name = "email")
    //@Pattern(regexp = "^[a-zA-Z0-9]{15}", message = "only 15 chars/digits")
    private String email;

    public employee() {
    }

    public employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
