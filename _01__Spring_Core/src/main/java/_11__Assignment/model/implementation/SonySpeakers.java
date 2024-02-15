package _11__Assignment.model.implementation;

import _11__Assignment.model.interfaces.Speakers;
import org.springframework.stereotype.Component;

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
