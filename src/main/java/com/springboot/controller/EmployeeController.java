package com.springboot.controller;

import com.springboot.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService employeeService){
        this.service = employeeService;
    }


}
