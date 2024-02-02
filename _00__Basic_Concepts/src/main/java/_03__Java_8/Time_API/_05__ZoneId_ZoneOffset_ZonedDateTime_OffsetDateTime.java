package _03__Java_8.Java_Time_API;

import org.apache.log4j.*;

import java.time.*;
import java.time.chrono.*;

public class _05__ZoneId_ZoneOffset_ZonedDateTime_OffsetDateTime {

    private static final Logger log = LogManager.getLogger(_05__ZoneId_ZoneOffset_ZonedDateTime_OffsetDateTime.class);

    public static void initialiseLog() {
        Layout layout = new PatternLayout("%n> LOG-ENTRY:- %n  -> [ %d ] %n     -> [ %C.%M ] %n        -> %p - %m %n");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
    }

    public static void main(String[] args) {
        initialiseLog();
        // 1. ZoneId class with ZonedDateTime, OffsetDateTime class
        ZoneId myZoneId = ZoneId.of("Asia/Kolkata");
        ZonedDateTime myZonedDateTimeByZoneId = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime myZonedDateTimeCompareByZoneId = myZonedDateTimeByZoneId.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime myZonedDateTimeCompareByZoneOffset = myZonedDateTimeByZoneId.withZoneSameInstant(ZoneOffset.of("-05:00"));
        OffsetDateTime myOffsetDateTimeByZoneId = OffsetDateTime.now(ZoneId.of("Asia/Kolkata"));
        // 2. ZoneOffset class with ZonedDateTime, OffsetDateTime class
        // use OffsetDateTime to deal with database operations related to storing dates and time
        // best way for database operations
        ZoneOffset myZoneOffset = ZoneOffset.of("+05:30");
        ZonedDateTime myZonedDateTimeByZoneOffset = ZonedDateTime.now(ZoneOffset.of("+05:30"));
        OffsetDateTime myOffsetDateTimeByZoneOffset = OffsetDateTime.now(ZoneOffset.of("+05:30"));
        OffsetDateTime myOffsetDateTimeCompare = myOffsetDateTimeByZoneOffset.withOffsetSameInstant(ZoneOffset.of("-05:00"));
        // best way to deal with custom dates stored in database that should be reflected to other countries according to ZoneOffset
        OffsetDateTime birthTimeAllCountries = OffsetDateTime.of(LocalDateTime.of(2003, 3, 4, 12, 30, 10), ZoneOffset.of("+05:30"));
        System.out.println("> BirthDay India: " + birthTimeAllCountries);
        birthTimeAllCountries = OffsetDateTime.of(LocalDateTime.of(2003, 3, 4, 12, 30, 10), ZoneOffset.of("+01:00"));
        System.out.println("> BirthDay Paris: " + birthTimeAllCountries);
        // few interesting methods
        System.out.println("> HijrahDate now: " + HijrahDate.now());
        // seconds passed from Jan 1st, 1970 till now
        System.out.println("> OffsetDateTime: " + myOffsetDateTimeByZoneOffset.toEpochSecond());
        System.out.println("> ZoneDateTime  : " + myZonedDateTimeCompareByZoneOffset.toEpochSecond());
        // custom function for logging process
        executeLog(myZoneId, myZonedDateTimeByZoneId, myZonedDateTimeCompareByZoneId, myZonedDateTimeCompareByZoneOffset, myOffsetDateTimeByZoneId);
        executeLog(myZoneOffset, myZonedDateTimeByZoneOffset, myOffsetDateTimeByZoneOffset, myOffsetDateTimeCompare);
    }

    public static void executeLog(ZoneId myZoneId, ZonedDateTime myZonedDateTimeByZoneId, ZonedDateTime myZonedDateTimeCompareByZoneId, ZonedDateTime myZonedDateTimeCompareByZoneOffset, OffsetDateTime myOffsetDateTimeByZoneId) {
        log.info("ZoneId                            : " + myZoneId
                + "\n                - ZonedDateTime(ByZoneId)           : " + myZonedDateTimeByZoneId
                + "\n                - ZonedDateTimeCompare(ByZoneId)    : " + myZonedDateTimeCompareByZoneId
                + "\n                - ZonedDateTimeCompare(ByZoneOffset): " + myZonedDateTimeCompareByZoneOffset
                + "\n                - OffsetDateTime(ByZoneId)          : " + myOffsetDateTimeByZoneId
        );
    }

    public static void executeLog(ZoneOffset myZoneOffset, ZonedDateTime myZonedDateTimeByZoneOffset, OffsetDateTime myOffsetDateTimeByZoneOffset, OffsetDateTime myOffsetDateTimeCompare) {
        log.info("ZoneOffset                  : " + myZoneOffset
                + "\n                - ZonedDateTime(ByZoneOffset) : " + myZonedDateTimeByZoneOffset
                + "\n                - OffsetDateTime(ByZoneOffset): " + myOffsetDateTimeByZoneOffset
                + "\n                - OffsetDateTimeCompare       : " + myOffsetDateTimeCompare
        );
    }

}
