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
    }

    public void initializeLog() {
        Layout layout = new PatternLayout("  LOGGING PROCESS: %p - %m %n");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
        System.out.println();
    }

    public void playMusic(boolean vehicleStarted, Song song) throws Exception {
        initializeLog();
        log.info("Method Started Executing The Code.");
        Instant startTime = Instant.now();
        String music = null;
        if (vehicleStarted) {
            music = speakers.makeSound(song);
            System.out.println(music);
            Thread.sleep(1000);
        } else {
            System.out.println("  > Please Start The Engine Of The Vehicle.");
            log.log(Priority.WARN, "The Engine Of The Vehicle Is OFF, Please Turn It ON.");
        }
        Instant endTime = Instant.now();
        log.info("Method Completed Executing The Code.");
        long timeInSeconds = Duration.between(startTime, endTime).toSeconds();
        long timeInMilliseconds = Duration.between(startTime, endTime).toMillis();
        log.info("Time Taken To Execute The Code: " + timeInSeconds + " seconds");
        log.info("Time Taken To Execute The Code: " + timeInMilliseconds + " milliseconds");
    }

    public void carGripOn(boolean vehicleStarted) throws Exception {
        initializeLog();
        log.info("Method Started Executing The Code.");
        Instant startTime = Instant.now();
        String drive = null;
        if (vehicleStarted) {
            drive = tyres.rotateTyres();
            System.out.println(drive);
            System.out.println("  > Let's Play Some Music  : " + tyres.getName());
            Thread.sleep(3500);
        } else {
            System.out.println("  > Please Start The Engine Of The Vehicle.");
            log.log(Priority.WARN, "The Engine Of The Vehicle Is OFF, Please Turn It ON.");
        }
        Instant endTime = Instant.now();
        log.info("Method Completed Executing The Code.");
        long timeInSeconds = Duration.between(startTime, endTime).toSeconds();
        long timeInMilliseconds = Duration.between(startTime, endTime).toMillis();
        log.info("Time Taken To Execute The Code: " + timeInSeconds + " seconds");
        log.info("Time Taken To Execute The Code: " + timeInMilliseconds + " milliseconds");
    }

    public void carGripOff(boolean vehicleStarted) throws Exception {
        initializeLog();
        log.info("Method Started Executing The Code.");
        Instant startTime = Instant.now();
        String drive = null;
        if (vehicleStarted) {
            drive = tyres.stopRotatingTyres();
            System.out.println(drive);
            System.out.println("  > Let's Enjoy The Scenery: " + tyres.getName());
            Thread.sleep(2500);
        } else {
            System.out.println("  > Please Start The Engine Of The Vehicle.");
            log.log(Priority.WARN, "The Engine Of The Vehicle Is OFF, Please Turn It ON.");
        }
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
