package _03__New_Java_8_Time_API;

import org.apache.log4j.*;

import java.time.*;

public class _03__LocalDateTime {

    private static final Logger log = LogManager.getLogger(_03__LocalDateTime.class);

    public static void initialiseLog() {
        Layout layout =
                new PatternLayout("%n> LOG-ENTRY:- %n  -> [ %d ] %n     -> [ %C.%M ] %n        -> %p - %m %n");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
    }

    public static void main(String[] args) {
        // all basic code related to logging
        initialiseLog();
        // returns LocalDateTime object which stores only current date & time and not timezones
        // LocalDateTime currentDateTime = LocalDateTime.now();
        java8LocalDateTimeMethods("Current", LocalDateTime.now());
        // we can also use: LocalDate.of(YYYY,MM,DD); LocalDate.parse("YYYY-MM-DD");
        // we can also use: LocalTime.of(HH,MM,SS); LocalTime.of("HH:MM:SS");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        // returns LocalDateTime object, stores only custom date & time and no timezone related things
        // LocalDateTime customDateTime1 = LocalDateTime.of(LocalDate date, LocalTime time);
        java8LocalDateTimeMethods("Custom", LocalDateTime.of(date, time));
        // LocalDateTime customDateTime2 = LocalDateTime.of(YYYY,MM,DD,HH,MM,SS);
        java8LocalDateTimeMethods("Custom", LocalDateTime.of(2003, 3, 4, 12, 30, 10));
        // LocalDateTime customDateTime3 = LocalDateTime.of(YYYY,Month.MONTH_NAME,DD,HH,MM,SS);
        java8LocalDateTimeMethods("Custom", LocalDateTime.of(2003, Month.MARCH, 4, 12, 30, 10));
        // returns LocalDateTime object, stores only parsed date & time and no timezone related things
        // LocalDateTime parseDateTime = LocalDateTime.parse("HH-MM-SS");
        //java8LocalDateTimeMethods("Parse", LocalDateTime.parse(""));
    }

    public static void java8LocalDateTimeMethods(String typeDateTime, LocalDateTime localDateTime) {
        int localDateTimeHashCode = localDateTime.hashCode();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        // other methods
        String hour = String.valueOf(localDateTime.getHour());
        String minute = String.valueOf(localDateTime.getMinute());
        String second = String.valueOf(localDateTime.getSecond());
        String nanosecond = String.valueOf(localDateTime.getNano());
        String year = String.valueOf(localDateTime.getYear());
        String month = String.valueOf(localDateTime.getMonth());
        String monthValue = String.valueOf(localDateTime.getMonthValue());
        String dayOfWeek = String.valueOf(localDateTime.getDayOfWeek());
        String dayOfMonth = String.valueOf(localDateTime.getDayOfMonth());
        String dayOfYear = String.valueOf(localDateTime.getDayOfYear());
        String chronology = String.valueOf(localDateTime.getChronology());
        executeLog(typeDateTime, localDateTime, localDateTimeHashCode, localDate, localTime, year, month, monthValue, dayOfWeek, dayOfMonth, dayOfYear, chronology, hour, minute, second, nanosecond);
    }

    // - - - other methods
    // localDateTime1.isBefore(localDateTime2);
    // localDateTime1.isAfter(localDateTime2);
    // localDateTime1.isEqual(localDateTime2);
    // - - - plusMethods();                      // - - - minusMethods();
    // localDateTime.plusYears(years-value);     // localDateTime.minusYears(years-value);
    // localDateTime.plusMonths(months-value);   // localDateTime.minusMonths(months-value);
    // localDateTime.plusDays(days-value);       // localDateTime.minusDays(days-value);
    // localDateTime.plusHours(hours-value);     // localDateTime.minusHours(hours-value);
    // localDateTime.plusMinutes(minutes-value); // localDateTime.minusMinutes(minutes-value);
    // localDateTime.plusSeconds(seconds-value); // localDateTime.minusSeconds(seconds-value);

    public static void executeLog(String typeDateTime, LocalDateTime localDateTime, int localDateTimeHashCode, LocalDate localDate, LocalTime localTime, String hour, String minute, String second, String nanosecond, String year, String month, String monthValue, String dayOfWeek, String dayOfMonth, String dayOfYear, String chronology) {
        log.info(typeDateTime + "Time: " + localDateTime
                + "\n                  - " + typeDateTime + "LocalDateTimeHashCode: " + localDateTimeHashCode
                + "\n                  - " + typeDateTime + "LocalDate     : " + localDate
                + "\n                  - " + typeDateTime + "LocalTime     : " + localTime
                + "\n                  - " + typeDateTime + "Year          : " + year
                + "\n                  - " + typeDateTime + "Month         : " + month
                + "\n                  - " + typeDateTime + "MonthValue    : " + monthValue
                + "\n                  - " + typeDateTime + "DayOfWeek     : " + dayOfWeek
                + "\n                  - " + typeDateTime + "DayOfMonth    : " + dayOfMonth
                + "\n                  - " + typeDateTime + "DayOfYear     : " + dayOfYear
                + "\n                  - " + typeDateTime + "Chronology    : " + chronology
                + "\n                  - " + typeDateTime + "TimeHour      : " + hour
                + "\n                  - " + typeDateTime + "TimeMinute    : " + minute
                + "\n                  - " + typeDateTime + "TimeSecond    : " + second
                + "\n                  - " + typeDateTime + "TimeNanoSecond: " + nanosecond
        );
    }

}
