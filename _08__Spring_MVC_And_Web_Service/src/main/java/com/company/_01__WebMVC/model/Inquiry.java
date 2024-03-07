package com.company._01__WebMVC.model;

import java.time.LocalDateTime;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entity_inquiry")
@Table(name = "table_inquiry", schema = "ecommerce")
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_inquiry_id")
    @SequenceGenerator(name = "generator_inquiry_id", sequenceName = "sequence_inquiry_id", initialValue = 1, allocationSize = 1)
    @Column(name = "inquiry_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "inquiry_date_created")
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "inquiry_date_updated")
    private LocalDateTime dateUpdated;

    @NotBlank(message = "first name must not be blank")
    @Size(min = 3, max = 20, message = "length of first name must be between {min} and {max}")
    @Column(name = "inquiry_first_name", length = 25, nullable = false)
    private String firstName;

    @NotBlank(message = "last name must not be blank")
    @Size(min = 3, max = 20, message = "length of last name must be between {min} and {max}")
    @Column(name = "inquiry_last_name", length = 25, nullable = false)
    private String lastName;

    @NotBlank(message = "email must not be blank")
    @Email(regexp = "[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com", message = "please provide a valid email")
    @Column(name = "inquiry_email", nullable = false, unique = true)
    private String email;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inquiry", optional = true)
    private Contact contact;

    @NotBlank(message = "question must not be blank")
    @Column(name = "inquiry_question", nullable = false)
    private String question;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "inquiry_tag", nullable = false)
    private Tag tag;

    @Override
    public String toString() {
        return "Inquiry {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", tag=" + tag +
                ", question='" + question + '\'' +
                ", countryName='" + contact.getContactPrefix().getCountryName() + '\'' +
                ", countryCode='" + contact.getContactPrefix().getCountryCode() + '\'' +
                ", contactNumber='" + contact.getContactNumber() + '\'' +
                '}';
    }

}
