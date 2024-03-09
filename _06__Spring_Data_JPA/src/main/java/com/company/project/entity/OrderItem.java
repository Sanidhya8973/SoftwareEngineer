package com.company.project.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "entity_order_item")
@Table(name = "table_order_item", schema = "ecommerce")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_order_item_id")
	@SequenceGenerator(name = "generator_order_item_id", sequenceName = "sequence_order_item_id", initialValue = 1, allocationSize = 1)
	@Column(name = "order_item_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_order_id")
	private Order order;

	@OneToOne
	@JoinColumn(name = "fk_product_id", nullable = false)
	private Product product;

	@Column(name = "order_item_quantity", nullable = false)
	private int quantity;

	@Column(name = "order_item_product_price_per_quantity", nullable = false)
	private BigDecimal totalOrdersItemAmount;

	public BigDecimal getTotalAmount() {
		BigDecimal amount = new BigDecimal(0);
		amount = this.product.getPrice().multiply(BigDecimal.valueOf(this.quantity));
		return amount;
	}

}