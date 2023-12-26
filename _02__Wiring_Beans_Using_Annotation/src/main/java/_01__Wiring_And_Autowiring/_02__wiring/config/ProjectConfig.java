package _01__Wiring_And_Autowiring._02__wiring.config;

import _01__Wiring_And_Autowiring._02__wiring.beans.Person;
import _01__Wiring_And_Autowiring._02__wiring.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        Vehicle v = new Vehicle();
        v.setName("FORD");
        return v;
    }

    // Wiring Beans...
    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("SANIDHYA");
        p.setVehicle(vehicle());
        return p;
    }

/*

    // Wiring Beans Using Method Parameters...
    @Bean
    public Person person(Vehicle vehicle) {
        Person p = new Person();
        p.setName("SANIDHYA");
        p.setVehicle(vehicle);
        return p;
    }

*/

}
