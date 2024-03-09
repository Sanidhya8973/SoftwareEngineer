package com.company.project.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_product_category")
@Table(name = "table_product_category", schema = "ecommerce", uniqueConstraints = {
		@UniqueConstraint(name = "unique_product_category_name", columnNames = "product_category_name") })
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_product_category_id")
	@SequenceGenerator(name = "generator_product_category_id", sequenceName = "sequence_product_category_id", initialValue = 1, allocationSize = 1)
	@Column(name = "product_category_id")
	private Long id;

	@Column(name = "product_category_name", nullable = true, unique = true)
	private String name;

	@Column(name = "product_category_description", nullable = true, unique = false)
	private String description;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Product> productList = new ArrayList<>();

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
