package com.spring_boot_crudProject.spring_boot_crudProject.controller;
import com.spring_boot_crudProject.spring_boot_crudProject.model.employee;
import com.spring_boot_crudProject.spring_boot_crudProject.service.employeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController("/app")

@Controller
public class employeeController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    private employeeService employeeService;

    @Autowired
    public employeeController(employeeService employeeService1){
        employeeService=employeeService1;
    }

    @GetMapping("/all")
    public String all(Model model){
        List<employee> empList=employeeService.findAll();
        model.addAttribute("allEmployee",empList);
        return "listEmployee";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model){
        employee employee=new employee();
        model.addAttribute("employee",employee);
        return "addEmployeeForm";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addEmployeeForm";
        }
        else {
            employeeService.save(employee);
            return "redirect:/all";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("employeeId") int id,Model model){
        employee employee=employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "addEmployeeForm";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id,Model model){
        employeeService.deleteById(id);
        return "redirect:/all";
    }

























    /*
    @GetMapping("/all")
    public List<employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/getById/{employeeId}")
    public employee getEmployee(@PathVariable int employeeId) {

        employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/save")
    public String addEmployee(@RequestBody employee theEmployee) {
        employeeService.save(theEmployee);
        return "data saved";
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody employee theEmployee) {
         employeeService.save(theEmployee);
        return "data update Successfully";
    }


    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee successfully";
    }
     */
}
