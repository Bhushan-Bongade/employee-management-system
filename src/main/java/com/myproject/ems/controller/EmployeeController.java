package com.myproject.ems.controller;

import com.myproject.ems.entity.Employee;
import com.myproject.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/showEmployees","/"})
    public ModelAndView showEmployee() {
        ModelAndView modelAndView = new ModelAndView("list-employees");
        List<Employee> list = employeeService.showEmployee();
        modelAndView.addObject("employees", list);
        return modelAndView;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployee() {
        ModelAndView modelAndView = new ModelAndView("add-employee-form");
        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployee")
    public ModelAndView updateEmployee(@RequestParam Long employeeId) {
        ModelAndView modelAndView = new ModelAndView("add-employee-form");
        Employee employee = employeeService.fetchEmployee(employeeId);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/";
    }
}
