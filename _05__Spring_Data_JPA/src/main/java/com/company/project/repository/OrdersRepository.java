package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.project.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
