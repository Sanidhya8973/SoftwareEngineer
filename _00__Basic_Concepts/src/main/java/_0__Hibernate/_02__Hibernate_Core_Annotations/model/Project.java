package _0__Hibernate._02__Hibernate_Core_Annotations.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity(name = "entity_project")
@Table(name = "table_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_project_id")
    @SequenceGenerator(name = "generator_project_id", sequenceName = "sequence_table_project_id", allocationSize = 1)
    @Column(name = "project_id")
    private int id;

    @Column(name = "project_name", length = 30, nullable = false, unique = false)
    private String name;

    @Column(name = "project_client", length = 30, nullable = false, unique = false)
    private String client;

    @Basic
    @Column(name = "project_start_date", nullable = true)
    private LocalDate startDate;

    @Column(name = "project_end_date", nullable = true)
    private LocalDate endDate;

    @ManyToMany(mappedBy = "project")
    private Employee employee;

    public Project() {

    }

    public Project(String name, String client, LocalDate startDate, LocalDate endDate) {
        super();
        this.name = name;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project(String name, String client, LocalDate startDate, LocalDate endDate, Employee employee) {
        super();
        this.name = name;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Project(int id, String name, String client, LocalDate startDate, LocalDate endDate, Employee employee) {
        super();
        this.id = id;
        this.name = name;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Project -> [ id=" + id + ", name=" + name + ", client=" + client + ", startDate=" + startDate + ", endDate=" + endDate + " ]";
    }

}