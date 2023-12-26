package _04__Lazy_Instantiation.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("vehicle")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Vehicle {

    private String name;

    public Vehicle() {
        this.name = "LEXUS LFA";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
