package com.thymeleaf_dropdown_propMethod.thymeleaf_dropdown_propMethod.controller;

import com.thymeleaf_dropdown_propMethod.thymeleaf_dropdown_propMethod.model.student;
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

    @GetMapping("form")
    public String form(Model model){
        student st=new student();
        model.addAttribute("student",st);
        model.addAttribute("country",country);
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("student") student st){
        System.out.println(st.getFirstName()+" "+st.getLastName()+" "+st.getCountry());
        return "submitForm";
    }
}
