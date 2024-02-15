package _07__Hibernate._02__Hibernate_Core_Annotations.model;

import jakarta.persistence.*;

@Entity(name = "entity_address")
@Table(name = "table_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_address_id")
    @SequenceGenerator(name = "generator_address_id", sequenceName = "sequence_table_address_id", allocationSize = 1)
    @Column(name = "address_id")
    private int id;

    @Column(name = "address_type", nullable = false, unique = false)
    private String type;

    @Column(name = "address_block", nullable = true, unique = false)
    private String block;

    @Column(name = "address_society", nullable = true, unique = false)
    private String society;

    @Column(name = "address_area", nullable = false, unique = false)
    private String area;

    @Column(name = "address_landmark", nullable = false, unique = false)
    private String landmark;

    @Column(name = "address_pincode", nullable = false, unique = false)
    private String pincode;

    @Column(name = "address_city", nullable = false, unique = false)
    private String city;

    @Column(name = "address_state", nullable = false, unique = false)
    private String state;

    @Column(name = "address_country", nullable = false, unique = false)
    private String country;

    @ManyToOne
    @JoinColumn(name = "address")
    private Employee employee;

    public Address() {

    }

    public Address(String type, String block, String society, String area, String landmark, String pincode, String city, String state,
                   String country) {
        super();
        this.type = type;
        this.block = block;
        this.society = society;
        this.area = area;
        this.landmark = landmark;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address(String type, String block, String society, String area, String landmark, String pincode, String city, String state, String country,
                   Employee employee) {
        super();
        this.type = type;
        this.block = block;
        this.society = society;
        this.area = area;
        this.landmark = landmark;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    public Address(int id, String type, String block, String society, String area, String landmark, String pincode, String city, String state,
                   String country, Employee employee) {
        super();
        this.id = id;
        this.type = type;
        this.block = block;
        this.society = society;
        this.area = area;
        this.landmark = landmark;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", type=" + type + ", block=" + block + ", society=" + society + ", area=" + area + ", landmark=" + landmark
                + ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
    }

}