package com.example.Employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Employee.model.Employee;
import com.example.Employee.repository.EmployeeRepository;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 👉 Landing page to show the form
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "index"; // index.html in templates
    }

    // 👉 Save employee from form
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/displayAll";
    }

    // 👉 Display all employees
    @GetMapping("/displayAll")
    public String displayAll(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "displayAll"; // displayAll.html
    }

    // 👉 Display single employee by empId
    @GetMapping("/display/{empId}")
    public String displayByEmpId(@PathVariable String empId, Model model) {
        Employee employee = employeeRepository.findByEmpId(empId);
        model.addAttribute("employee", employee);
        return "displayOne"; // displayOne.html
    }
}