package _10__Wiring_And_Autowiring._04__circular_dependency.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;
    private final Vehicle vehicle;

    @Autowired
    public Person(Vehicle vehicle) {
        this.name = "SANIDHYA";
        this.vehicle = vehicle;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("\n> Beans Creation   : success");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("\n> Beans Destruction: success");
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setName(String name) {
        this.name = name;
    }

}
