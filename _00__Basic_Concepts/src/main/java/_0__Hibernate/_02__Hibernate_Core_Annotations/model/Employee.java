package _0__Hibernate._02__Hibernate_Core_Annotations.model;

import jakarta.persistence.*;

import java.util.*;
import java.time.LocalDate;

@Entity(name = "entity_employee")
@Table(name = "table_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_employee_id")
    @SequenceGenerator(name = "generator_employee_id", sequenceName = "sequence_table_employee_id", allocationSize = 1)
    @Column(name = "employee_id")
    private long id;

    @Lob
    @Column(name = "employee_image", nullable = true)
    private byte[] image;

    @Column(name = "employee_first_name", length = 20, nullable = false, unique = false)
    private String firstName;

    @Column(name = "employee_last_name", length = 20, nullable = false, unique = false)
    private String lastName;

    @Column(name = "employee_email", nullable = false, unique = true)
    private String email;

    @Column(name = "employee_password", nullable = false, unique = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_gender")
    private Gender gender;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "employee_date_of_birth", nullable = false, unique = false)
    private LocalDate dateOfBirth;

    @Transient
    private int currentAge;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "signature", column = @Column(name = "employee_certificate_signature")),
            @AttributeOverride(name = "name", column = @Column(name = "employee_certificate_name")),
            @AttributeOverride(name = "startDate", column = @Column(name = "employee_certificate_start")),
            @AttributeOverride(name = "endDate", column = @Column(name = "employee_certificate_end")),
    })
    private Certificate certificate;

    @ElementCollection
    @CollectionTable(name = "table_employee_skills", joinColumns = @JoinColumn(name = "fk_employee_id", referencedColumnName = "employee_id"))
    @Column(name = "employee_skills")
    // here it sets the column name of Collection<WrapperClass> that stores Collection<WrapperClass> object
    private Set<String> skills = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "join_table_employee_project", joinColumns = @JoinColumn(name = "fk_employee_id"), inverseJoinColumns = @JoinColumn(name = "fk_project_id"))
    private List<Project> project = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "join_table_employee_contact", joinColumns = @JoinColumn(name = "fk_employee_id"), inverseJoinColumns = @JoinColumn(name = "fk_contact_id"))
    private Set<Contact> contact = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "join_table_employee_address", joinColumns = @JoinColumn(name = "fk_employee_id"), inverseJoinColumns = @JoinColumn(name = "fk_address_id"))
    private List<Address> address = new ArrayList<>();

    @Basic
    @Column(name = "employee_join_date", nullable = false, unique = false)
    private LocalDate joinDate;

    @Basic
    @Column(name = "employee_leave_date", nullable = true, unique = false)
    private LocalDate leaveDate;

    public Employee() {

    }

    public Employee(byte[] image, String firstName, String lastName, String email, String password, Gender gender, LocalDate dateOfBirth,
                    int currentAge, Certificate certificate, Set<String> skills, List<Project> project, Set<Contact> contact, List<Address> address,
                    LocalDate joinDate, LocalDate leaveDate) {
        super();
        this.image = image;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.currentAge = currentAge;
        this.certificate = certificate;
        this.skills = skills;
        this.project = project;
        this.contact = contact;
        this.address = address;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
    }

    public Employee(long id, byte[] image, String firstName, String lastName, String email, String password, Gender gender, LocalDate dateOfBirth,
                    int currentAge, Certificate certificate, Set<String> skills, List<Project> project, Set<Contact> contact, List<Address> address,
                    LocalDate joinDate, LocalDate leaveDate) {
        super();
        this.id = id;
        this.image = image;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.currentAge = currentAge;
        this.certificate = certificate;
        this.skills = skills;
        this.project = project;
        this.contact = contact;
        this.address = address;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    public Set<Contact> getContact() {
        return contact;
    }

    public void setContact(Set<Contact> contact) {
        this.contact = contact;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Override
    public String toString() {
        return "Employee -> [ id=" + id + ", image=" + Arrays.toString(image) + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
                + email + ", password=" + password + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", currentAge=" + currentAge
                + ", certificate=" + certificate + ", skills=" + skills + ", project=" + project + ", contact=" + contact + ", address=" + address
                + ", joinDate=" + joinDate + ", leaveDate=" + leaveDate + " ]";
    }

}
