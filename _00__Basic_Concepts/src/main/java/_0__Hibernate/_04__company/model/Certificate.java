package _0__Hibernate._04__company.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Embeddable
public class Certificate {

    @Column(name = "signature", length = 20, nullable = false, unique = false)
    private String signature;

    @Column(name = "name", length = 20, nullable = false, unique = false)
    private String name;

    @Basic
    @Column(name = "start")
    private LocalDate startDate;

    @Basic
    @Column(name = "end")
    private LocalDate endDate;

    public Certificate() {

    }

    public Certificate(String signature, String name, LocalDate startDate, LocalDate endDate) {
        super();
        this.signature = signature;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
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
        return "\n> Certificate -> [ signature=" + signature + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + " ]";
    }

}