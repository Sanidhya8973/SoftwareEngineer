package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.domain.OrdersItem;

@Repository(value = "repository_orders_item")
public interface OrdersItemRepository extends JpaRepository<OrdersItem, Long> {

}
