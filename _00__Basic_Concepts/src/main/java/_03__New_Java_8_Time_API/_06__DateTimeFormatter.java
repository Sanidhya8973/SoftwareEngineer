package _03__New_Java_Time_API;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class _06__DateTimeFormatter {

    public static void main(String[] args) {
        System.out.println("> Basic DateTimeFormatter Class Methods That Are Used Widely...");
        System.out.println("> " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("> " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        System.out.println("> " + LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        System.out.println("> " + LocalTime.now().format(DateTimeFormatter.ISO_TIME));
        System.out.println("> " + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("> " + LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("> " + LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("> " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("> " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("> " + OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        System.out.println("> " + ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }
  
}
