package _01__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_1.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;
    private final Vehicle vehicle;

    @Autowired
    public Person(Vehicle vehicle1) {
        this.vehicle = vehicle1;
    }

    @PostConstruct
    public void initialize() {
        this.name = "SANIDHYA";
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
