package _10__Wiring_And_Autowiring._03__autowiring._01__autowiring_with_single_bean_of_same_type.beans.autowired_required_true.using_setter;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// This way of coding can not be recommended for production usage...

@Component
public class Person {

    private String name;
    private Vehicle vehicle;

    @PostConstruct
    public void initialize() {
        this.name = "SANIDHYA";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    // @Autowired(required = true)
    @Autowired
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}