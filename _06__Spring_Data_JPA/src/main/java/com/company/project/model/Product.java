package com.company.project.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_product")
@Table(name = "table_product", schema = "ecommerce")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_product_id")
	@SequenceGenerator(name = "generator_product_id", sequenceName = "sequence_product_id", initialValue = 1, allocationSize = 1)
	@Column(name = "product_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_product_category_id")
	private ProductCategory productCategory;

	@Column(name = "product_stock_keeping_unit", nullable = false, unique = true)
	private String stockKeepingUnit;

	@Column(name = "product_name", nullable = false)
	private String name;

	@Column(name = "product_description", nullable = false)
	private String description;

	@Column(name = "product_price", nullable = false)
	private BigDecimal price;

	@Column(name = "product_image_url", nullable = false)
	private String imageUrl;

	@Column(name = "product_active")
	private Boolean active;

	@CreationTimestamp
	private LocalDateTime dateCreated;

	@UpdateTimestamp
	private LocalDateTime dateUpdated;

	@Override
	public String toString() {
		return "Product [id=" + id + ", productCategory=" + productCategory + ", stockKeepingUnit=" + stockKeepingUnit
				+ ", name=" + name + ", description=" + description + ", price=" + price + ", imageUrl=" + imageUrl
				+ ", active=" + active + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}

}
