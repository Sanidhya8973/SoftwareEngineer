package _11__Assignment.services;

import _11__Assignment.model.interfaces.Speakers;
import _11__Assignment.model.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    private Speakers speakers;
    private Tyres tyres;

    @Autowired
    public VehicleServices(Speakers speakers, Tyres tyres) {
        this.speakers = speakers;
        this.tyres = tyres;
    }

    public void playMusic() {
        String music = speakers.makeSound();
        System.out.println("> Playing Music From " + getSpeakers().getName() + " Sound System.");
        System.out.println("- " + music);
    }

    public void carGrip() {
        String tyre = tyres.rotateTyres();
        System.out.println("> Car Has " + getTyres().getName() + " Tyres.");
        System.out.println("- " + tyre);
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

}