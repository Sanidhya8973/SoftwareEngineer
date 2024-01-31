package _0__Hibernate._04__company.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity(name = "employee")
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Lob
    @Column(name = "employee_image")
    private byte[] image;

    @Column(name = "employee_name", length = 20, nullable = false, unique = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_id")
    private Gender gender;

    @Column(name = "employee_email", length = 50, nullable = false, unique = true)
    private String email;

    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = "employee_joining_date")
    private LocalDateTime joiningDateTime;
    // Deprecated
    // @Temporal(TemporalType.TIMESTAMP)
    // private Date joiningDate;

    @Transient
    private String token;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "signature", column = @Column(name = "certificate_signature")),
            @AttributeOverride(name = "name", column = @Column(name = "certificate_name")),
            @AttributeOverride(name = "start", column = @Column(name = "certificate_start")),
            @AttributeOverride(name = "end", column = @Column(name = "certificate_end")),
    })
    private Certificate certificate;

    @OneToMany(mappedBy = "employee")
    @JoinColumn(name = "employee_address_details")
    List<Address> addressList;

    @Column(name = "employee_salary", nullable = false, unique = false)
    private double salary;

    @Column(name = "employee_password", nullable = false, unique = false)
    private String password;

    public Employee() {

    }

    public Employee(byte[] image, String name, Gender gender, String email, LocalDateTime joiningDateTime, String token, Certificate certificate,
                    List<Address> addressList, double salary, String password) {
        super();
        this.image = image;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.joiningDateTime = joiningDateTime;
        this.token = token;
        this.certificate = certificate;
        this.addressList = addressList;
        this.salary = salary;
        this.password = password;
    }

    public Employee(long id, byte[] image, String name, Gender gender, String email, LocalDateTime joiningDateTime, String token,
                    Certificate certificate, List<Address> addressList, double salary, String password) {
        super();
        this.id = id;
        this.image = image;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.joiningDateTime = joiningDateTime;
        this.token = token;
        this.certificate = certificate;
        this.addressList = addressList;
        this.salary = salary;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getJoiningDateTime() {
        return joiningDateTime;
    }

    public void setJoiningDateTime(LocalDateTime joiningDateTime) {
        this.joiningDateTime = joiningDateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\n> Employee -> [ id=" + id + ", image=" + Arrays.toString(image) + ", name=" + name + ", gender=" + gender + ", email=" + email
                + ", joiningDateTime=" + joiningDateTime + ", token=" + token + ", certificate=" + certificate + ", addressList=" + addressList
                + ", salary=" + salary + ", password=" + password + " ]";
    }

}