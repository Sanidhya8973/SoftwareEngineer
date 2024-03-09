package com.company.project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.project.entity.Payment;

@Repository(value = "repository_payment")
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
