package com.codecrafters.request_params.controllers;

import com.codecrafters.request_params.models.Employee;
import com.codecrafters.request_params.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String department,
                                       @RequestParam(required = false) BigDecimal minSalary,
                                       @RequestParam(required = false) LocalDate hiredAfter,
                                       @RequestParam(required = false) LocalDate hiredBefore,
                                       @RequestParam(required = false) Boolean active) {
        return employeeService.getEmployees(firstName, department, minSalary, hiredAfter, hiredBefore, active);
    }
}
