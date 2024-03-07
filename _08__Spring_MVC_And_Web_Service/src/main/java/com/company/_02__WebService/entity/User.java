package com.company._02__WebService.entity;

import java.util.List;
import java.util.ArrayList;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_user")
@Table(name = "table_user", schema = "ecommerce_web_service", uniqueConstraints = @UniqueConstraint(name = "unique_user_email", columnNames = "user_email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_user_id")
    @SequenceGenerator(name = "generator_user_id", sequenceName = "sequence_user_id", initialValue = 1, allocationSize = 1)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "user_last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "user_email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roleList = new ArrayList<>();

    public List<String> getRoleListToString() {
        List<String> roles = new ArrayList<>();
        for (Role role : this.roleList) {
            roles.add(role.getName());
        }
        return roles;
    }

    @Override
    public String toString() {
        return "User -> [ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + " ]";
    }

}