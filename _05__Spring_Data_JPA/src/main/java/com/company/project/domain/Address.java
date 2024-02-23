package com.company.project.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "entity_address")
@Table(name = "table_address", schema = "ecommerce")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_address_id")
	@SequenceGenerator(name = "generator_address_id", sequenceName = "sequence_address_id", initialValue = 1, allocationSize = 1)
	@Column(name = "address_id")
	private Long id;

	@Column(name = "address_street", nullable = true)
	private String street;

	@Column(name = "address_pincode", nullable = true)
	private String pincode;

	@Column(name = "address_city", nullable = true)
	private String city;

	@Column(name = "address_state", nullable = true)
	private String state;

	@Column(name = "address_country", nullable = true)
	private String country;

	@OneToOne
	@JoinColumn(name = "fk_orders_id")
	private Orders orders;

}
