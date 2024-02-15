package _02__Understand_NoUniqueBeanDefinitionException.config;

import _02__Understand_NoUniqueBeanDefinitionException.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import org.springframework.context.annotation.Configuration;
// Spring @Configuration annotation is part of the Spring Core Framework.
// Spring @Configuration annotation indicates that the class has @Bean definition methods.
// So, Spring container can process the class and generate Spring Beans to be used in the application.
@Configuration
public class ProjectConfig {

    // import org.springframework.context.annotation.Bean;
    // @Bean annotation lets Spring know that it needs to call this method when it initializes its context and adds the returned value to the context.
    @Bean
    Vehicle vehicle1() {
        var myVehicle = new Vehicle();
        myVehicle.setName("FORD");
        return myVehicle;
    }

    @Bean
    Vehicle vehicle2() {
        var myVehicle = new Vehicle();
        myVehicle.setName("AUDI");
        return myVehicle;
    }

    @Bean
    Vehicle vehicle3() {
        var myVehicle = new Vehicle();
        myVehicle.setName("LAMBORGHINI");
        return myVehicle;
    }

    // The method names usually follow verbs notation, but for methods which we will use to create beans; can use names as nouns.
    // This will be a good practice as the method names will become bean names as well in the context.
    // Example for what to use: vehicle, bike, car, food, greet, number, student, boy, girl, parents, father, mother, son, daughter, etc...
    // Example what not to use: getVehicle, getGreetings, getBike, getCar, makeFood, drawNumber, getStudentList, getBoy, getGirl, etc...

}
