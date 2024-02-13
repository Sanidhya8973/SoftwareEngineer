package _0__Hibernate._02__Hibernate_Core_Annotations.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Embeddable
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_certificate_id")
    @SequenceGenerator(name = "generator_certificate_id", sequenceName = "sequence_table_certificate_id", allocationSize = 1)
    @Column(name = "certificate_signature")
    private int signature;

    @Column(name = "certificate_name", length = 20, nullable = false, unique = false)
    private String name;

    @Basic
    @Column(name = "certificate_start")
    private LocalDate startDate;

    @Basic
    @Column(name = "certificate_end")
    private LocalDate endDate;

    public Certificate() {

    }

    public Certificate(int signature, String name, LocalDate startDate, LocalDate endDate) {
        super();
        this.signature = signature;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getSignature() {
        return signature;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "\n Certificate -> [ signature=" + signature + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + " ]";
    }

}