package com.thymeleaf_checkBox.thymeleaf_checkBox.controller;

import com.thymeleaf_checkBox.thymeleaf_checkBox.model.student;
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

    @Value("${gender}")
    private List<String> gender;

    @Value("${skill}")
    private List<String> skill;

    @GetMapping("/form")
    public String form(Model model){
        student student=new student();
        model.addAttribute("student",student);
        model.addAttribute("country",country);
        model.addAttribute("skill",skill);
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("student") student student){
        return "submitForm";
    }
}
