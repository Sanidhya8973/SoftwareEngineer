package _02__Assignment.services;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import _02__Assignment.model.interfaces.Speakers;
import _02__Assignment.model.interfaces.Tyres;

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

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

}