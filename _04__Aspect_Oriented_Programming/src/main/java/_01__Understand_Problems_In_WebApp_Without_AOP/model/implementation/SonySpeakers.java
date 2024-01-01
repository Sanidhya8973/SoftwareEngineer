package _01__Understand_Problems_In_WebApp_Without_AOP.model.implementation;

import _01__Understand_Problems_In_WebApp_Without_AOP.model.beans.Song;
import _01__Understand_Problems_In_WebApp_Without_AOP.model.interfaces.Speakers;
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
        return "    > " + getName() + ": Playing Song: " + song.getName() + ", By " + song.getSinger();
    }

}