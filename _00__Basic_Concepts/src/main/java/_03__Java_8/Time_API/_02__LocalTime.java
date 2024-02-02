package _03__Java_8.Java_Time_API;

import org.apache.log4j.*;

import java.time.*;

public class _02__LocalTime {

    private static final Logger log = LogManager.getLogger(_02__LocalTime.class);

    public static void initialiseLog() {
        Layout layout =
                new PatternLayout("%n> LOG-ENTRY:- %n  -> [ %d ] %n     -> [ %C.%M ] %n        -> %p - %m %n");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
    }

    public static void main(String[] args) {
        // all basic code related to logging
        initialiseLog();
        // returns LocalTime object which stores only current time and no date related things
        // LocalTime currentTime = LocalTime.now();
        java8LocalTimeMethods("Current", LocalTime.now());
        // returns LocalTime object which stores only custom time and no date related things
        // LocalTime customTime = LocalTime.of(hour, minute, second);
        java8LocalTimeMethods("Custom", LocalTime.of(12, 30, 10));
        // returns LocalTime object which stores only parsed time and no date related things
        // LocalTime parseTime = LocalTime.parse("HH-MM-SS");
        java8LocalTimeMethods("Parse", LocalTime.parse("11:45:30"));
    }

    public static void java8LocalTimeMethods(String timeType, LocalTime time) {
        int timeHashCode = time.hashCode();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        int nanosecond = time.getNano();
        // custom function to print formatted logs
        executeLog(timeType, time, timeHashCode, hour, minute, second, nanosecond);
    }

    public static void executeLog(String timeType, LocalTime time, int timeHashCode, int hour, int minute, int second, int nanosecond) {
        log.info(timeType + "Time: " + time
                + "\n                  - " + timeType + "TimeHashCode  : " + timeHashCode
                + "\n                  - " + timeType + "TimeHour      : " + hour
                + "\n                  - " + timeType + "TimeMinute    : " + minute
                + "\n                  - " + timeType + "TimeSecond    : " + second
                + "\n                  - " + timeType + "TimeNanoSecond: " + nanosecond
        );
    }

}
