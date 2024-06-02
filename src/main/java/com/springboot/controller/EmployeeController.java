package com.springboot.controller;

import com.springboot.model.Employee;
import com.springboot.model.Player;
import com.springboot.model.Status;
import com.springboot.model.Team;
import com.springboot.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.SessionStatusMethodArgumentResolver;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService employeeService){
        this.service = employeeService;
    }


    @QueryMapping
    public List<Employee> getEmployees(){
        return this.service.getEmployees();
    }

    @QueryMapping
    public Optional<Employee> getEmployee(@Argument @PathVariable String id){
        return this.service.getEmployee(id);
    }

    @MutationMapping
    public Employee createEmployee(@Argument String name, @Argument String email, @Argument double salary, @Argument Status status){
        return this.service.createEmployee(new Employee("",name,email,salary,status));
    }

    @MutationMapping
    public Employee updateEmployee(@Argument String id, @Argument String name, @Argument String email, @Argument double salary, @Argument Status status){
        return this.service.updateEmployee(new Employee(id,name,email,salary,status));
    }

    @MutationMapping
    public String deleteEmployee(@Argument String id){
        return this.service.deleteEmployee(id);
    }

}
