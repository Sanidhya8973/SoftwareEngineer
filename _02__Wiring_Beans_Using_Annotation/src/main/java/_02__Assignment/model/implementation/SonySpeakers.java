package _02__Assignment.model.implementation;

import org.springframework.stereotype.Component;
import _02__Assignment.model.interfaces.Speakers;

@Component
public class SonySpeakers implements Speakers {

    private final String name = "SONY";

    public String getName() {
        return name;
    }

    public String makeSound() {
        return "SONY SPEAKERS: active";
    }

}
