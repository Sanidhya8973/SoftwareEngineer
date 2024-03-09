package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.entity.OrderItem;

@Repository(value = "repository_orders_item")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
