package com.company.project.domain;

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
@Entity(name = "entity_orders")
@Table(name = "table_orders", schema = "ecommerce")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_orders_id")
	@SequenceGenerator(name = "generator_orders_id", sequenceName = "sequence_orders_id", initialValue = 1, allocationSize = 1)
	@Column(name = "orders_id")
	private Long id;

	@OneToOne(mappedBy = "orders", cascade = CascadeType.ALL)
	private Address address;

	@Column(name = "orders_tracking_number", nullable = false, unique = true)
	private String trackingNumber;

	@Column(name = "orders_status", nullable = false)
	private String status;

	@Column(name = "orders_total_quantity", nullable = false)
	private int totalQuantity;

	@Column(name = "orders_total_price", nullable = false)
	private BigDecimal totalPrice;

	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<OrdersItem> ordersItemList = new ArrayList<>();

	public BigDecimal getTotalAmount() {
		BigDecimal amount = new BigDecimal(0);
		for (OrdersItem oi : this.ordersItemList) {
			amount = amount.add(oi.getTotalOrdersItemAmount());
		}
		return amount;
	}

}