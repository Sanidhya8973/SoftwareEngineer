package com.company.project.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_contact")
@Table(name = "table_contact", schema = "ecommerce")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_contact_id")
    @SequenceGenerator(name = "generator_contact_id", sequenceName = "sequence_contact_id", initialValue = 1, allocationSize = 1)
    @Column(name = "contact_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_inquiry_id")
    private Inquiry inquiry;

    @Pattern(regexp = "[0-9]{10}", message = "please enter a valid contact number")
    @Column(name = "contact_contact_number", nullable = false, unique = true)
    private String contactNumber;

    @Valid
    @OneToOne
    @JoinColumn(name = "fk_contact_prefix_id", nullable = false)
    private ContactPrefix contactPrefix;

    @Override
    public String toString() {
        return "Contact {" +
                "id=" + id +
                ", countryName='" + contactPrefix.getCountryName() + '\'' +
                ", countryCode='" + contactPrefix.getCountryCode() + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

}
