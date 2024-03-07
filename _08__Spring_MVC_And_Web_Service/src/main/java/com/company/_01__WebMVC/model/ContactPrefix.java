package com.company._01__WebMVC.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_contact_prefix")
@Table(name = "table_contact_prefix", schema = "ecommerce")
public class ContactPrefix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_prefix_country_id")
    private Long id;

    @NotBlank(message = "please enter your country name")
    @Size(min = 4, max = 43, message = "please enter a valid country name and length must be between {min} and {max}")
    @Column(name = "contact_prefix_country_name", nullable = false, unique = true)
    private String countryName;

    @Pattern(regexp = "[+][0-9]+", message = "please provide a valid country code")
    @Column(name = "contact_prefix_country_code", nullable = false, unique = true)
    private String countryCode;

    @Override
    public String toString() {
        return "ContactPrefix {" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }

}
