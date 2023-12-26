package _01__Types_Of_Beans_Scope._1__Singleton_Beans_Scope.config;

import _01__Types_Of_Beans_Scope._1__Singleton_Beans_Scope.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Primary
    @Bean("vehicle1")
    Vehicle lexus() {
        var myVehicle = new Vehicle();
        myVehicle.setName("LEXUS");
        return myVehicle;
    }

    @Bean("vehicle2")
    Vehicle ford() {
        var myVehicle = new Vehicle();
        myVehicle.setName("FORD");
        return myVehicle;
    }

    @Bean("vehicle3")
    Vehicle honda() {
        var myVehicle = new Vehicle();
        myVehicle.setName("HONDA");
        return myVehicle;
    }

}
