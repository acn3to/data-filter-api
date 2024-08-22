package com.codecrafters.request_params.specs;

import com.codecrafters.request_params.models.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeSpecification {

    public static Specification<Employee> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) ->
                firstName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Employee> hasDepartment(String department) {
        return (root, query, criteriaBuilder) ->
                department == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("department")), "%" + department.toLowerCase() + "%");
    }

    public static Specification<Employee> hasSalaryGreaterThanOrEqualTo(BigDecimal minSalary) {
        return (root, query, criteriaBuilder) ->
                minSalary == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary);
    }

    public static Specification<Employee> wasHiredAfter(LocalDate hiredAfter) {
        return (root, query, criteriaBuilder) ->
                hiredAfter == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("hireDate"), hiredAfter);
    }

    public static Specification<Employee> wasHiredBefore(LocalDate hiredBefore) {
        return (root, query, criteriaBuilder) ->
                hiredBefore == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("hireDate"), hiredBefore);
    }

    public static Specification<Employee> isActive(Boolean active) {
        return (root, query, criteriaBuilder) ->
                active == null ? null : criteriaBuilder.equal(root.get("active"), active);
    }
}
