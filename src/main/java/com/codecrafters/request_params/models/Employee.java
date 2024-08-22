package com.codecrafters.request_params.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "position", nullable = false)
    private String position;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @NotNull
    @PastOrPresent
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "department", nullable = false)
    private String department;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;
}
