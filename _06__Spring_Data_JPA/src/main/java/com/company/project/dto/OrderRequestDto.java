package com.company.project.dto;

import lombok.*;
import com.company.project.entity.Order;
import com.company.project.entity.Payment;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private Order order;

    private Payment payment;

}
