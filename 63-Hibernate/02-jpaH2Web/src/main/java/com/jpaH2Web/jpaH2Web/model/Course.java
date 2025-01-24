package com.jpaH2Web.jpaH2Web.model;

import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    private long id;
    //now name cant be null
    @Column(name = "name", nullable = false,unique = true)
    private String name;

    public Course() {
    }

    public Course(int id,String name) {
        this.id=id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
