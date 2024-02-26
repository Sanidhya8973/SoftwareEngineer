package com.company.project.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_role")
@Table(name = "table_role", schema = "ecommerce")
// uniqueConstraints = @UniqueConstraint(name = "unique_role_name", columnNames = "role_name"))
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_role_id")
	@SequenceGenerator(name = "generator_role_id", sequenceName = "sequence_role_id", initialValue = 1, allocationSize = 1)
	@Column(name = "role_id")
	private Long id;

	@Column(name = "role_name", nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "join_table_user_and_role", joinColumns = @JoinColumn(name = "fk_role_id"), inverseJoinColumns = @JoinColumn(name = "fk_user_id"))
	private List<User> userList = new ArrayList<>();

	public List<String> getUserListToString() {
		List<String> users = new ArrayList<>();
		for (User user : this.userList) {
			users.add("id=" + user.getId() + ", name=" + user.getFirstName() + " " + user.getLastName());
		}
		return users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
