package _02__AOP_Terms.model.implementation;

import _02__AOP_Terms.model.beans.Song;
import _02__AOP_Terms.model.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component("sonySpeakers")
public class SonySpeakers implements Speakers {

    private final String name;

    public SonySpeakers() {
        this.name = "SONY SPEAKERS";
    }

    public String getName() {
        return this.name;
    }

    public String makeSound(Song song) {
        return "> " + getName() + ": Playing Song: " + song.getName() + ", By " + song.getSinger();
    }

}