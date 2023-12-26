package _03__Custom_Name_To_The_Bean.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import _03__Custom_Name_To_The_Bean.beans.Vehicle;

// There are 3 ways to give custom names to the Bean...
// 1) @Bean(name = "___")
// 2) @Bean(value = "___")
// 3) @Bean("___")

@Configuration
public class ProjectConfig {

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
