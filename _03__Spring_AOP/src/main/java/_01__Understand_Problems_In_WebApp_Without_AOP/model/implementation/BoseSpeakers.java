package _01__Understand_Problems_In_WebApp_Without_AOP.model.implementation;

import _01__Understand_Problems_In_WebApp_Without_AOP.model.beans.Song;
import _01__Understand_Problems_In_WebApp_Without_AOP.model.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("boseSpeakers")
@Primary
public class BoseSpeakers implements Speakers {

    private final String name;

    public BoseSpeakers() {
        this.name = "BOSE SPEAKERS";
    }

    public String getName() {
        return this.name;
    }

    public String makeSound(Song song) {
        return "    > " + getName() + ": Playing Song: " + song.getName() + ", By " + song.getSinger();
    }

}
