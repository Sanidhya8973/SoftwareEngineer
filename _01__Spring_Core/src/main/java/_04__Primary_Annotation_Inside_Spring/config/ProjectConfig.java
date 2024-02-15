package _04__Primary_Annotation_Inside_Spring.config;

import _04__Primary_Annotation_Inside_Spring.beans.Vehicle;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Bean;

// When we have multiple beans of the same kind inside the Spring Context, we can make one of them primary by using @Primary annotation.
// Primary bean is the one which Spring will choose if it has multiple options, and we do not specify a name.
// In other words, it is the default bean that Spring Context will consider in case of confusion due to multiple beans present of same type.

@Configuration
public class ProjectConfig {

    @Primary
    @Bean(name = "fordVehicle")
    Vehicle vehicle1() {
        var myVehicle = new Vehicle();
        myVehicle.setName("FORD");
        return myVehicle;
    }

    @Bean(value = "hondaVehicle")
    Vehicle vehicle2() {
        var myVehicle = new Vehicle();
        myVehicle.setName("HONDA");
        return myVehicle;
    }

    @Bean("lamborghiniVehicle")
    Vehicle vehicle3() {
        var myVehicle = new Vehicle();
        myVehicle.setName("LAMBORGHINI");
        return myVehicle;
    }

}
