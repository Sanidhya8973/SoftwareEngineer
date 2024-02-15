package _02__AOP_Terms.model.implementation;

import _02__AOP_Terms.model.beans.Song;
import _02__AOP_Terms.model.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("boseSpeakers")
public class BoseSpeakers implements Speakers {

    private final String name;

    public BoseSpeakers() {
        this.name = "BOSE SPEAKERS";
    }

    public String getName() {
        return this.name;
    }

    public String makeSound(Song song) {
        return "> " + getName() + ": Playing Song: " + song.getName() + ", By " + song.getSinger();
    }

}
