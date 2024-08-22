package com.codecrafters.request_params.services;

import com.codecrafters.request_params.models.Employee;
import com.codecrafters.request_params.repositories.EmployeeRepository;
import com.codecrafters.request_params.specs.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(String firstName, String department, BigDecimal minSalary,
                                       LocalDate hiredAfter, LocalDate hiredBefore, Boolean active) {
        Specification<Employee> spec = Specification.where(EmployeeSpecification.hasFirstName(firstName))
                .and(EmployeeSpecification.hasDepartment(department))
                .and(EmployeeSpecification.hasSalaryGreaterThanOrEqualTo(minSalary))
                .and(EmployeeSpecification.wasHiredAfter(hiredAfter))
                .and(EmployeeSpecification.wasHiredBefore(hiredBefore))
                .and(EmployeeSpecification.isActive(active));

        return employeeRepository.findAll(spec);
    }
}
