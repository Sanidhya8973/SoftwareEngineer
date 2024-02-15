package _11__Assignment.model.implementation;

import _11__Assignment.model.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BoseSpeakers implements Speakers {

    private final String name = "BOSE";

    public String getName() {
        return name;
    }

    public String makeSound() {
        return "BOSE SPEAKERS: active";
    }

}
