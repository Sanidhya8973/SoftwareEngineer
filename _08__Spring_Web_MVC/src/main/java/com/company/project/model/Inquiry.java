package com.company.project.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "inquiry_first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "inquiry_last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "inquiry_email", nullable = false, unique = true)
    private String email;

    @Column(name = "inquiry_contact", nullable = true)
    private String contact;

    @Column(name = "inquiry_question", nullable = false)
    private String question;

    @Column(name = "inquiry_type", nullable = false)
    private Type type;

    public enum Type {
        COURSES, FACULTY, FEE, TIMETABLE, EXAMINATION, HOLIDAY
    }

    @Override
    public String toString() {
        return "Inquiry -> [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", contact=" + contact + ", question=" + question + ", type=" + type + "]";
    }

}
