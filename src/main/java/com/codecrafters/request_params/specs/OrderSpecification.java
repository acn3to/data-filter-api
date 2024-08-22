package com.codecrafters.request_params.specs;

import com.codecrafters.request_params.models.Order;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderSpecification {

    public static Specification<Order> hasOrderNumber(String orderNumber) {
        return (root, query, criteriaBuilder) ->
                orderNumber == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("orderNumber")), "%" + orderNumber.toLowerCase() + "%");
    }

    public static Specification<Order> hasCustomerName(String customerName) {
        return (root, query, criteriaBuilder) ->
                customerName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("customerName")), "%" + customerName.toLowerCase() + "%");
    }

    public static Specification<Order> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
                status == null ? null : criteriaBuilder.equal(criteriaBuilder.lower(root.get("status")), status.toLowerCase());
    }

    public static Specification<Order> hasAmountRange(BigDecimal minAmount, BigDecimal maxAmount) {
        return (root, query, criteriaBuilder) -> {
            if (minAmount != null && maxAmount != null)
                return criteriaBuilder.between(root.get("totalAmount"), minAmount, maxAmount);
            else if (minAmount != null)
                return criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minAmount);
            else if (maxAmount != null)
                return criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxAmount);
            else
                return null;
        };
    }

    public static Specification<Order> hasDateRange(LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {
            if (startDate != null && endDate != null)
                return criteriaBuilder.between(root.get("orderDate"), startDate, endDate);
            else if (startDate != null)
                return criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate);
            else if (endDate != null)
                return criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate);
            else
                return null;
        };
    }
}
