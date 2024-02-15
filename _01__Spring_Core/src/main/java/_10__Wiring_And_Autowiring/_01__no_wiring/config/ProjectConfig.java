package _10__Wiring_And_Autowiring._01__no_wiring.config;

import _10__Wiring_And_Autowiring._01__no_wiring.beans.Person;
import _10__Wiring_And_Autowiring._01__no_wiring.beans.Vehicle;
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

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("SANIDHYA");
        return p;
    }

}
