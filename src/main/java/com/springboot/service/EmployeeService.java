package com.springboot.service;

import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.repository = employeeRepository;
    }


    public List<Employee> getEmployees(){
        List<Employee> employees = this.repository.findAll();
        if (employees.isEmpty()){
            return Collections.emptyList();
        }
        return employees.stream().toList();
    }

    public Optional<Employee> getEmployee(String id){
        return this.repository.findById(id);
    }

    public Employee createEmployee(Employee employee){
        employee.setId(UUID.randomUUID().toString());
        this.repository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee){
        Optional<Employee> optional = this.repository.findById(employee.getId());
        if (optional.isPresent()){
            optional.get().setName(employee.getName());
            optional.get().setEmail(employee.getEmail());
            optional.get().setSalary(employee.getSalary());
            optional.get().setStatus(employee.getStatus());
            this.repository.save(optional.get());
            return optional.get();
        }
        return null;
    }

    public String deleteEmployee(String id){
        if (this.repository.findById(id).isPresent()){
            this.repository.deleteById(id);
            return "Deleted";
        }
        return "Not Deleted";
    }




}
