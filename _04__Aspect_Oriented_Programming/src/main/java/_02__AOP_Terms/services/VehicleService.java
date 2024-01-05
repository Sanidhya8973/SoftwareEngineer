package _02__AOP_Terms.services;

import _02__AOP_Terms.model.beans.Song;
import _02__AOP_Terms.model.interfaces.Speakers;
import _02__AOP_Terms.model.interfaces.Tyres;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("vehicleService")
public class VehicleService {

    private static final Logger log = LogManager.getLogger(VehicleService.class);
    private final Speakers speakers;
    private final Tyres tyres;

    @Autowired
    public VehicleService(Speakers speakers, Tyres tyres) {
        this.speakers = speakers;
        this.tyres = tyres;
        // fixed multiple logging problem when methods like carGripOn(), carGripOff() and playMusic() invoked
        initializeLog();
    }

    public void initializeLog() {
        Layout layout = new PatternLayout("  %p - %m %n");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
    }

    public void playMusic(boolean vehicleStarted, Song song) throws Exception {
        String music = speakers.makeSound(song);
        Thread.sleep(1000);
        System.out.println(music);
    }

    public void carGripOn(boolean vehicleStarted) throws Exception {
        String drive = tyres.rotateTyres();
        System.out.println("> Let's Drive And Enjoy  : " + tyres.getName());
        Thread.sleep(3500);
        System.out.println(drive);
    }

    public void carGripOff(boolean vehicleStarted) throws Exception {
        String drive = tyres.stopRotatingTyres();
        System.out.println("> Let's Enjoy The Scenery: " + tyres.getName());
        Thread.sleep(2500);
        System.out.println(drive);
    }

    public String getSpeakersData() {
        return speakers.toString() + " -> " + speakers.getName();
    }

    public String getTyresData() {
        return tyres.toString() + " -> " + tyres.getName();
    }

}
