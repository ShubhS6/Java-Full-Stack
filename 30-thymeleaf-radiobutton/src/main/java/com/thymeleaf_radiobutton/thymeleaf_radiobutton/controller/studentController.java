package com.thymeleaf_radiobutton.thymeleaf_radiobutton.controller;

import com.thymeleaf_radiobutton.thymeleaf_radiobutton.model.student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class studentController {

    @Value("${country}")
    private List<String> country;

    @GetMapping("/form")
    public String form(Model model){
        student student=new student();
        model.addAttribute("student",student);
        model.addAttribute("country",country);
        return "form";
    }

    @PostMapping("/submitForm")
    public String SubmitForm(@ModelAttribute("student") student student){
        return "submitForm";
    }
}
