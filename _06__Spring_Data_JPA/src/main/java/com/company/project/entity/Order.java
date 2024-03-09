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
@ToString
@Entity(name = "entity_order")
@Table(name = "table_order", schema = "ecommerce")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_order_id")
	@SequenceGenerator(name = "generator_orders_id", sequenceName = "sequence_order_id", initialValue = 1, allocationSize = 1)
	@Column(name = "order_id")
	private Long id;

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Address address;

	@Column(name = "order_tracking_number", nullable = false, unique = true)
	private String trackingNumber;

	@Column(name = "order_status", nullable = false)
	private String status;

	@Column(name = "order_total_quantity", nullable = false)
	private int totalQuantity;

	@Column(name = "order_total_price", nullable = false)
	private BigDecimal totalPrice;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItemList = new ArrayList<>();

	public BigDecimal getTotalAmount() {
		BigDecimal amount = new BigDecimal(0);
		for (OrderItem oi : this.orderItemList) {
			amount = amount.add(oi.getTotalOrdersItemAmount());
		}
		return amount;
	}

}