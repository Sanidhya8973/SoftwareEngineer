package _03__Eager_Instantiation.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("person")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Person {

    private String name;
    private final Vehicle vehicle;

    @Autowired
    public Person(Vehicle vehicle) {
        this.vehicle = vehicle;
        setName("SANIDHYA");
        System.out.println("> Beans Instantiation: EAGER INSTANTIATION");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
