package _03__Java_8.Java_Time_API;

import org.apache.log4j.*;

import java.time.*;

public class _01__LocalDate {

    private static final Logger log = LogManager.getLogger(_01__LocalDate.class);

    public static void initialiseLog() {
        Layout layout =
                new PatternLayout("%n> LOG-ENTRY:- %n  -> [ %d ] %n     -> [ %C.%M ] %n        -> %p - %m %n");
        Appender appender = new ConsoleAppender(layout);
        log.addAppender(appender);
    }

    public static void main(String[] args) {
        // all basic code related to logging
        initialiseLog();
        // 1. returns LocalDate object which stores only current date and no time related things
        // LocalDate currentDate = LocalDate.now();
        java8LocalDateMethods("Current", LocalDate.now());
        // 2. returns LocalDate object which stores only current date and no time related things
        // LocalDate customDate = LocalDate.of(year, month, day);
        java8LocalDateMethods("Custom", LocalDate.of(2003, 3, 4));
        // 3. returns LocalDate object which stores only parsed date and no time related things
        // LocalDate parseDate = LocalDate.parse("YYYY-MM-DD");
        java8LocalDateMethods("Parse", LocalDate.parse("2003-03-04"));
    }

    public static void java8LocalDateMethods(String dateType, LocalDate date) {
        // we used String.valueOf(); method to eliminate the confusion between return type of different methods
        // examples: int, DayOfWeek, Month
        String dayOfWeek = String.valueOf(date.getDayOfWeek());    // returns enum DayOfWeek object value
        String dayOfMonth = String.valueOf(date.getDayOfMonth());  // returns primitive int object value
        String dayOfYear = String.valueOf(date.getDayOfYear());    // returns primitive int object value
        String month = String.valueOf(date.getMonth());            // returns
        String monthValue = String.valueOf(date.getMonthValue());  // returns
        String monthLength = String.valueOf(date.lengthOfMonth()); // returns
        String year = String.valueOf(date.getYear());              // returns
        String yearLength = String.valueOf(date.lengthOfYear());   // returns
        String chronology = String.valueOf(date.getChronology());  // returns
        String era = String.valueOf(date.getEra());                // returns
        String checkLeapYear = String.valueOf(date.isLeapYear());  // returns boolean object value
        if (checkLeapYear.equalsIgnoreCase("true")) {
            checkLeapYear = "Year Is A Leap Year";
        } else {
            checkLeapYear = "Year Is Not A Leap Year";
        }
        executeLog(dateType, String.valueOf(date), checkLeapYear, dayOfWeek, dayOfMonth, dayOfYear, month, monthValue, monthLength, year, yearLength, chronology, era);
    }

    public static void executeLog(String typeDateTime, String date, String checkLeapYear, String dayOfWeek, String dayOfMonth, String dayOfYear, String month, String monthValue, String monthLength, String year, String yearLength, String chronology, String era) {
        log.info(typeDateTime + "Date: " + date
                + "\n                  - " + typeDateTime + "DayOfWeek  : " + dayOfWeek
                + "\n                  - " + typeDateTime + "DayOfMonth : " + dayOfMonth
                + "\n                  - " + typeDateTime + "DayOfYear  : " + dayOfYear
                + "\n                  - " + typeDateTime + "Month      : " + month
                + "\n                  - " + typeDateTime + "MonthValue : " + monthValue
                + "\n                  - " + typeDateTime + "MonthLength: " + monthLength
                + "\n                  - " + typeDateTime + "Year       : " + year
                + "\n                  - " + typeDateTime + "YearLength : " + yearLength
                + "\n                  - " + typeDateTime + " " + checkLeapYear
                + "\n                  - " + typeDateTime + "Chronology : " + chronology
                + "\n                  - " + typeDateTime + "Era        : " + era
        );
    }

}
