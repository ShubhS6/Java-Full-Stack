package com.springboot_restCrud.springboot_restCrud.restController;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        if(student.size()<id || id<0){
            throw new studentNotFoundException("Student not found "+id);
        }
        return student.get(id);
    }

    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(studentNotFoundException ex){
        studentErrorResponse error=new studentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleAnyException(Exception ex){
        studentErrorResponse error=new studentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
