package com.hibernateOneToMany.hibernateOneToMany.model;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comment")
    private String comment;


    public review() {
    }

    public review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
