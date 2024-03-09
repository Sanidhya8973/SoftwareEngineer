package com.company.project.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_payment")
@Table(name = "table_payment", schema = "ecommerce")
public class Payment {
    @Id
    private Long id;
}
