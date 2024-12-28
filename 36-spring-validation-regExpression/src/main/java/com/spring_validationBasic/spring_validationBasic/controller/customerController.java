package com.spring_validationBasic.spring_validationBasic.controller;

import com.spring_validationBasic.spring_validationBasic.model.customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class customerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("customer",new customer());
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("customer") customer customer,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        else {
            return "submitForm";
        }
    }
}
