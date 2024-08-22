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
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @NotNull
    @PastOrPresent
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;
}
