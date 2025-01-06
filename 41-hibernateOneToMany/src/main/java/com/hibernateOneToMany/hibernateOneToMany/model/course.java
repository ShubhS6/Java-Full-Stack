package com.hibernateOneToMany.hibernateOneToMany.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private instructor instructor;

    public course() {
    }

    public course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public com.hibernateOneToMany.hibernateOneToMany.model.instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(com.hibernateOneToMany.hibernateOneToMany.model.instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
