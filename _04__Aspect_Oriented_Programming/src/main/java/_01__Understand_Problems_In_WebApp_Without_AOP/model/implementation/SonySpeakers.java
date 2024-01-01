package _01__Understand_Problems_In_WebApp_Without_AOP.model.implementation;

import _01__Understand_Problems_In_WebApp_Without_AOP.model.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component("sonySpeakers")
public class SonySpeakers implements Speakers {

    private String name;

    public SonySpeakers() {
        this.name = "SONY SPEAKERS";
    }

    public String getName() {
        return this.name;
    }

    public String makeSound() {
        return "  > " + getName() + ": active";
    }

}