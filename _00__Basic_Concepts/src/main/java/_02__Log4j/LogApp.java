package _02__Log4j;

import org.apache.log4j.*;

public class LogApp {

    // STEP-0: Create Logger Object
    private static Logger log = LogManager.getLogger(LogApp.class);

    public static void main(String[] args) throws Exception {
        // STEP-1: Create Layout Object
        Layout layout1 = new PatternLayout("> [%d] -> [%C.%M] : %p - %m %n");
        Layout layout2 = new SimpleLayout();
        // Layout layout3 = new HTMLLayout();
        // Layout layout4 = new XMLLayout();
        // Layout layout5 = new DateLayout();
        // STEP-2: Create Appender + Link Layout
        Appender appender1 = new ConsoleAppender(layout1);
        Appender appender2 = new FileAppender(layout2, "D:/_Programmer_/java/IntelliJ/SpringFrameworkProjects/_00__Basic_Concepts/src/main/java/_02__Log4j_Codes/log-file.log");
        // STEP-3: Link Appender With Logger
        log.addAppender(appender1);
        log.addAppender(appender2);
        // 4. Print Messages
        log.debug("FROM DEBUG");
        log.info("FROM INFO");
        log.warn("FROM WARN");
        log.error("FROM ERROR");
        log.fatal("FROM FATAL");
    }

}
