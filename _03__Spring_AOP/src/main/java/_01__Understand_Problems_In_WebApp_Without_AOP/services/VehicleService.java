package _01__Understand_Problems_In_WebApp_Without_AOP.services;

import _01__Understand_Problems_In_WebApp_Without_AOP.model.beans.Song;
import org.apache.log4j.*;

import java.time.*;

import _01__Understand_Problems_In_WebApp_Without_AOP.model.interfaces.Speakers;
import _01__Understand_Problems_In_WebApp_Without_AOP.model.interfaces.Tyres;
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
        log.info("LOGS: playMusic(boolean vehicleStarted, Song song);");
        log.info("Method Started Executing The Code.");
        Instant startTime = Instant.now();
        String music = null;
        if (vehicleStarted) {
            music = speakers.makeSound(song);
            Thread.sleep(1000);
        } else {
            System.out.println("    > Please Start The Engine Of The Vehicle.");
            log.log(Priority.WARN, "The Engine Of The Vehicle Is OFF, Please Turn It ON.");
        }
        System.out.println(music);
        Instant endTime = Instant.now();
        log.info("Method Completed Executing The Code.");
        long timeInSeconds = Duration.between(startTime, endTime).toSeconds();
        long timeInMilliseconds = Duration.between(startTime, endTime).toMillis();
        log.info("Time Taken To Execute The Code: " + timeInSeconds + " seconds");
        log.info("Time Taken To Execute The Code: " + timeInMilliseconds + " milliseconds");
    }

    public void carGripOn(boolean vehicleStarted) throws Exception {
        log.info("LOGS: carGripOn(boolean vehicleStarted);");
        log.info("Method Started Executing The Code.");
        Instant startTime = Instant.now();
        String drive = null;
        if (vehicleStarted) {
            drive = tyres.rotateTyres();
            System.out.println("    > Let's Drive And Enjoy  : " + tyres.getName());
            Thread.sleep(3500);
        } else {
            System.out.println("    > Please Start The Engine Of The Vehicle.");
            log.log(Priority.WARN, "The Engine Of The Vehicle Is OFF, Please Turn It ON.");
        }
        System.out.println(drive);
        Instant endTime = Instant.now();
        log.info("Method Completed Executing The Code.");
        long timeInSeconds = Duration.between(startTime, endTime).toSeconds();
        long timeInMilliseconds = Duration.between(startTime, endTime).toMillis();
        log.info("Time Taken To Execute The Code: " + timeInSeconds + " seconds");
        log.info("Time Taken To Execute The Code: " + timeInMilliseconds + " milliseconds");
    }

    public void carGripOff(boolean vehicleStarted) throws Exception {
        log.info("LOGS: carGripOff(boolean vehicleStarted);");
        log.info("Method Started Executing The Code.");
        Instant startTime = Instant.now();
        String drive = null;
        if (vehicleStarted) {
            drive = tyres.stopRotatingTyres();
            System.out.println("    > Let's Enjoy The Scenery: " + tyres.getName());
            Thread.sleep(2500);
        } else {
            System.out.println("    > Please Start The Engine Of The Vehicle.");
            log.log(Priority.WARN, "The Engine Of The Vehicle Is OFF, Please Turn It ON.");
        }
        System.out.println(drive);
        Instant endTime = Instant.now();
        log.info("Method Completed Executing The Code.");
        long timeInSeconds = Duration.between(startTime, endTime).toSeconds();
        long timeInMilliseconds = Duration.between(startTime, endTime).toMillis();
        log.info("Time Taken To Execute The Code: " + timeInSeconds + " seconds");
        log.info("Time Taken To Execute The Code: " + timeInMilliseconds + " milliseconds");
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

}
