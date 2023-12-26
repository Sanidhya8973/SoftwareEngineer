package _01__Wiring_And_Autowiring._04__circular_dependency.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import _01__Wiring_And_Autowiring._04__circular_dependency.beans.Vehicle;

@Configuration
@ComponentScan(basePackages = "_01__Wiring_And_Autowiring._04__circular_dependency.beans")
public class ProjectConfig {

    @Bean
    @Primary
    public Vehicle vehicle() {
        var v = new Vehicle();
        v.setName("FORD");
        return v;
    }

}
