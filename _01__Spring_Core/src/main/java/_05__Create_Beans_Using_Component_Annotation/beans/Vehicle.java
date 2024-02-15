package _05__Create_Beans_Using_Component_Annotation.beans;

import org.springframework.stereotype.Component;

// @Component is one of the most commonly used stereotype annotation by developers.
// Using this we can easily create and add a bean to the Spring Context by writing less code compared to the @Bean annotation.
// With Stereotype annotations, we need to add the annotation above the class for which we need to have an instance in the Spring Context.
// Using @ComponentScan() annotation over the configuration class, instructs Spring on where to find the classes you marked with stereotype annotations.
// @ComponentScan(basePackages = "___") i.e. @ComponentScan(basePackages = "com.sanidhya.beans")

@Component
public class Vehicle {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void verifyPrototype() {
        System.out.println("> PROTOTYPE: working");
    }

}
