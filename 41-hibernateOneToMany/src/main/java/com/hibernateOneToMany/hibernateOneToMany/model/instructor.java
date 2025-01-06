package com.hibernateOneToMany.hibernateOneToMany.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private  String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private instructorDetail instructorDetail;
    @OneToMany(mappedBy = "instructor",cascade = {
            CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH
    },fetch = FetchType.EAGER)
    private List<course> courseList;

    public com.hibernateOneToMany.hibernateOneToMany.model.instructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(com.hibernateOneToMany.hibernateOneToMany.model.instructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public instructor() {
    }

    public instructor(String firstName, String lastName, String email) {
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

    @Override
    public String toString() {
        return "instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }




    public List<course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(course tempCourse){
        if(courseList==null){
            courseList=new ArrayList<>();
        }
        courseList.add(tempCourse);
        tempCourse.setInstructor(this);
    }
}
