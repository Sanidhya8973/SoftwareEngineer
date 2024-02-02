package _03__Java_8.Java_Time_API;

import org.apache.log4j.*;

import java.time.*;

public class _04__Instant_Duration_Period {

    public static final Logger log = LogManager.getLogger(_04__Instant_Duration_Period.class);

    public static void initialiseLog() {
        Layout layout = new PatternLayout("%n> LOG-ENTRY:- %n  -> [ %d ] %n     -> [ %C.%M ] %n        -> %p - %m %n");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
    }

    public static void main(String[] args) throws Exception {
        initialiseLog();
        // 1. Instant class with Duration class
        Instant instant1 = Instant.ofEpochSecond(5);
        Instant instant2 = Instant.ofEpochSecond(10, 1_000);
        Instant instant3 = Instant.ofEpochSecond(10, -1_000);
        System.out.println("> " + instant1 + "\n" + "> " + instant2 + "\n" + "> " + instant3);
        Instant startInstant = Instant.now();
        Thread.sleep(1000);
        Instant endInstant = Instant.now();
        Duration durationInstant = Duration.between(startInstant, endInstant);
        // 2. LocalTime class with Duration class
        LocalTime startLocalTime = LocalTime.of(6, 30, 10);
        LocalTime endLocalTime = LocalTime.of(20, 30, 20);
        Duration durationLocalTime = Duration.between(startLocalTime, endLocalTime);
        // 3. LocalDateTime class with Duration class
        LocalDateTime startDateTime = LocalDateTime.of(2023, 12, 29, 6, 30, 10);
        LocalDateTime endDateTime = LocalDateTime.of(2023, 12, 30, 3, 30, 20);
        Duration durationDateTime = Duration.between(startDateTime, endDateTime);
        // 4. LocalDate class with Period class
        LocalDate startLocalDate = LocalDate.of(2003, 3, 4);
        LocalDate endLocalDate = LocalDate.now();
        Period periodLocalDate = Period.between(startLocalDate, endLocalDate);
        // logging all date and time related data
        executeLog(durationInstant);
        executeLog(durationLocalTime);
        executeLog(durationDateTime);
        executeLog(periodLocalDate);
    }

    public static void executeLog(Period period) {
        log.info("duration             : " + period
                + "\n                - duration.hashcode    : " + period.hashCode()
                + "\n                - duration.isNegative(): " + period.isNegative()
                + "\n                - duration.isZero()    : " + period.isZero()
                + "\n                - duration.getUnits()  : " + period.getUnits()
                + "\n                - duration.getClass()  : " + period.getClass()
                + "\n                  - duration. : " + period
        );
    }

    public static void executeLog(Duration duration) {
        log.info("duration             : " + duration
                + "\n                - duration.hashcode    : " + duration.hashCode()
                + "\n                - duration.isNegative(): " + duration.isNegative()
               // + "\n                - duration.isPositive(): " + duration.isPositive()
                + "\n                - duration.isZero()    : " + duration.isZero()
                + "\n                  - duration.getNano()       : " + duration.getNano()
                + "\n                  - duration.getSeconds()    : " + duration.getSeconds()
                + "\n                  - duration.getUnits()      : " + duration.getUnits()
                + "\n                  - duration.getClass()      : " + duration.getClass()
                + "\n                  - duration.toNanos()       : " + duration.toNanos()
                + "\n                  - duration.toMillis()      : " + duration.toMillis()
                + "\n                  - duration.toSeconds()     : " + duration.toSeconds()
                + "\n                  - duration.toMinutes()     : " + duration.toMinutes()
                + "\n                  - duration.toHours()       : " + duration.toHours()
                + "\n                  - duration.toDays()        : " + duration.toDays()
                + "\n                  - duration.toNanosPart()   : " + duration.toNanosPart()
                + "\n                  - duration.toMillisPart()  : " + duration.toMillisPart()
                + "\n                  - duration.toSecondsPart() : " + duration.toSecondsPart()
                + "\n                  - duration.toMinutesPart() : " + duration.toMinutesPart()
                + "\n                  - duration.toHoursPart()   : " + duration.toHoursPart()
                + "\n                  - duration.toDaysPart()    : " + duration.toDaysPart()
                + "\n                  - duration.abs()                : " + duration.abs()
                + "\n                  - duration.abs().hashCode()     : " + duration.abs().hashCode()
                + "\n                  - duration.abs().toString()     : " + duration.abs().toString()
                + "\n                  - duration.abs().toNanos()      : " + duration.abs().toNanos()
                + "\n                  - duration.abs().toMillis()     : " + duration.abs().toMillis()
                + "\n                  - duration.abs().toSeconds()    : " + duration.abs().toSeconds()
                + "\n                  - duration.abs().toMinutes()    : " + duration.abs().toMinutes()
                + "\n                  - duration.abs().toHours()      : " + duration.abs().toHours()
                + "\n                  - duration.abs().toDays()       : " + duration.abs().toDays()
                + "\n                  - duration.abs().toNanosPart()  : " + duration.abs().toNanosPart()
                + "\n                  - duration.abs().toMillisPart() : " + duration.abs().toMillisPart()
                + "\n                  - duration.abs().toSecondsPart(): " + duration.abs().toSecondsPart()
                + "\n                  - duration.abs().toMinutesPart(): " + duration.abs().toMinutesPart()
                + "\n                  - duration.abs().toHoursPart()  : " + duration.abs().toHoursPart()
                + "\n                  - duration.abs().toDaysPart()   : " + duration.abs().toDaysPart()
        );
    }

}
