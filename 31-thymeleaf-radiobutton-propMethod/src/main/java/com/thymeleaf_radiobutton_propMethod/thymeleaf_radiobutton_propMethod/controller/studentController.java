package com.thymeleaf_radiobutton_propMethod.thymeleaf_radiobutton_propMethod.controller;

import com.thymeleaf_radiobutton_propMethod.thymeleaf_radiobutton_propMethod.model.student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class studentController {
    @Value("${country}")
    private List<String> country;

    @Value("${gender}")
    private List<String> gender;

    @GetMapping("/form")
    public String form(Model model){
        student student=new student();
        model.addAttribute("student",student);
        model.addAttribute("country",country);
        model.addAttribute("gender",gender);
        return "form";
    }

    @PostMapping("/submitForm")
    public String SubmitForm(@ModelAttribute("student") student st){
        return "submitForm";
    }
}
