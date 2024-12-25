package com.thymeleaf_helloworld.thymeleaf_helloworld.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class helloController {

    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @PostMapping("/submitform")
    public String submitform(HttpServletRequest http,Model model){
        String name=http.getParameter("fname");
        name=name.toUpperCase();
        model.addAttribute("message",name);
        return "show";
    }
}
