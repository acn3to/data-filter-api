package com.codecrafters.request_params.services;

import com.codecrafters.request_params.models.Order;
import com.codecrafters.request_params.repositories.OrderRepository;
import com.codecrafters.request_params.specs.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(String orderNumber, String customerName, String status,
                                 BigDecimal minAmount, BigDecimal maxAmount,
                                 LocalDate startDate, LocalDate endDate) {
        Specification<Order> spec = Specification.where(OrderSpecification.hasOrderNumber(orderNumber))
                .and(OrderSpecification.hasCustomerName(customerName))
                .and(OrderSpecification.hasStatus(status))
                .and(OrderSpecification.hasAmountRange(minAmount, maxAmount))
                .and(OrderSpecification.hasDateRange(startDate, endDate));

        return orderRepository.findAll(spec);
    }
}
