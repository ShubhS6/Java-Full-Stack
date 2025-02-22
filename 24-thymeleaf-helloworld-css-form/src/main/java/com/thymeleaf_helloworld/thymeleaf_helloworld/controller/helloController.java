package com.thymeleaf_helloworld.thymeleaf_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data",java.time.LocalTime.now());
        return "Hello-world";
    }
}
