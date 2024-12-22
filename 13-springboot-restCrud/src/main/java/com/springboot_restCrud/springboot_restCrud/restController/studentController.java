package com.springboot_restCrud.springboot_restCrud.restController;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot_restCrud.springboot_restCrud.model.student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    public List<student> student;

    @PostConstruct
    public void create(){
        student=new ArrayList<>();
        student.add(new student("shubham","Vishwa"));
        student.add(new student("Ana","Vishwa"));
        student.add(new student("Manish","Maurya"));
        student.add(new student("Raj","Yadav"));
        student.add(new student("Shreya","Verma"));
    }

    @GetMapping("/all")
    public List<student> all(){
        return student;
    }

    @GetMapping("/studentId/{id}")
    public student id(@PathVariable int id){
        return student.get(id);
    }
}
