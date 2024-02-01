package _0__Hibernate._02__Hibernate_Annotations.model;

import jakarta.persistence.*;

@Entity(name = "address")
@Table(name = "address_details")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "type", nullable = false, unique = false)
    private String type;

    @Column(name = "block", nullable = false, unique = false)
    private String block;

    @Column(name = "society", nullable = false, unique = false)
    private String society;

    @Column(name = "street", nullable = false, unique = false)
    private String street;

    @Column(name = "landmark", nullable = false, unique = false)
    private String landmark;

    @Column(name = "pincode", nullable = false, unique = false)
    private int pincode;

    @Column(name = "city", nullable = false, unique = false)
    private String city;

    @Column(name = "state", nullable = false, unique = false)
    private String state;

    @Column(name = "country", nullable = false, unique = false)
    private String country;

    public Address() {

    }

    public Address(String type, String block, String society, String street, String landmark, int pincode, String city, String state, String country) {
        super();
        this.type = type;
        this.block = block;
        this.society = society;
        this.street = street;
        this.landmark = landmark;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
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

    @Override
    public String toString() {
        return "\n> Address -> [ id=" + id + ", type=" + type + ", block=" + block + ", society=" + society + ", street=" + street + ", landmark=" + landmark + ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", country=" + country + " ]";
    }

}