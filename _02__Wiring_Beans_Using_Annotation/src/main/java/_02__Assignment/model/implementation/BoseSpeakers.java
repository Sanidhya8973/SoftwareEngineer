package _02__Assignment.model.implementation;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import _02__Assignment.model.interfaces.Speakers;

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
