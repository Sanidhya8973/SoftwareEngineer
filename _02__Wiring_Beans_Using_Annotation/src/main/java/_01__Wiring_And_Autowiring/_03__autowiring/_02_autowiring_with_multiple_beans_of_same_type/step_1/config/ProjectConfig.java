package _01__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_1.config;

import _01__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_1.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "_01__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_1.beans")
public class ProjectConfig {

    @Bean
    Vehicle vehicle1() {
        var v = new Vehicle();
        v.setName("FORD");
        return v;
    }

    @Bean
    Vehicle vehicle2() {
        var v = new Vehicle();
        v.setName("HONDA");
        return v;
    }

    @Bean
    Vehicle vehicle3() {
        var v = new Vehicle();
        v.setName("LAMBORGHINI");
        return v;
    }

}
