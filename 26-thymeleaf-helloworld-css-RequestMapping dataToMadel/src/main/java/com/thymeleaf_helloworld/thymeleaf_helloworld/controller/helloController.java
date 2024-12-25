package com.thymeleaf_helloworld.thymeleaf_helloworld.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {

    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @PostMapping("/submitform")
    public String submitform(@RequestParam("fname") String name, Model model){
        name=name.toUpperCase();
        model.addAttribute("message",name);
        return "show";
    }
}
