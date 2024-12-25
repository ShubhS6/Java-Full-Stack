package com.thymeleaf_helloworld.thymeleaf_helloworld.controller;

import com.thymeleaf_helloworld.thymeleaf_helloworld.model.student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class formController {

    @GetMapping("/form")
    public String form(Model model){
        student st=new student();
        model.addAttribute("student",st);
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("student") student st){
        return "submitForm";
    }
}
