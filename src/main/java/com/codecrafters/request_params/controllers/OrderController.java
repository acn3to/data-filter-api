package com.codecrafters.request_params.controllers;

import com.codecrafters.request_params.models.Order;
import com.codecrafters.request_params.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam(required = false) String orderNumber,
                                 @RequestParam(required = false) String customerName,
                                 @RequestParam(required = false) String status,
                                 @RequestParam(required = false) BigDecimal minAmount,
                                 @RequestParam(required = false) BigDecimal maxAmount,
                                 @RequestParam(required = false) LocalDate startDate,
                                 @RequestParam(required = false) LocalDate endDate) {
        return orderService.getOrders(orderNumber, customerName, status, minAmount, maxAmount, startDate, endDate);
    }
}
