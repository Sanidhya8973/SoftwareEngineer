package _07__Hibernate._02__Hibernate_Core_Annotations.model;

import jakarta.persistence.*;

@Entity(name = "entity_contact")
@Table(name = "table_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_contact_id")
    @SequenceGenerator(name = "generator_contact_id", sequenceName = "sequence_table_contact_id", allocationSize = 1)
    @Column(name = "contact_id")
    private long id;

    @Column(name = "contact_place", nullable = true)
    private String type;

    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "contact")
    private Employee employee;

    public Contact() {

    }

    public Contact(String type, String contactNumber) {
        super();
        this.type = type;
        this.contactNumber = contactNumber;
    }

    public Contact(String type, String contactNumber, Employee employee) {
        super();
        this.type = type;
        this.contactNumber = contactNumber;
        this.employee = employee;
    }

    public Contact(long id, String type, String contactNumber, Employee employee) {
        super();
        this.id = id;
        this.type = type;
        this.contactNumber = contactNumber;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Contact -> [ id=" + id + ", type=" + type + ", contactNumber=" + contactNumber + " ]";
    }

}
