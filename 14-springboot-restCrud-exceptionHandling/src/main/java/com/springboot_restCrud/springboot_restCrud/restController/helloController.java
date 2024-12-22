package com.springboot_restCrud.springboot_restCrud.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class helloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
