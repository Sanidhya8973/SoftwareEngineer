package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.project.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
