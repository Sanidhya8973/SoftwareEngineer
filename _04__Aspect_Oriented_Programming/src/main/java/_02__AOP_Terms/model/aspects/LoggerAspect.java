package _02__AOP_Terms.model.aspects;

import org.apache.log4j.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger logs = Logger.getLogger(LoggerAspect.class);

    public LoggerAspect() {
        Layout layout = new SimpleLayout();
        Appender appender = new ConsoleAppender(layout);
        logs.addAppender(appender);
    }

    @Around("execution(public void _02__AOP_Terms.services.VehicleService.*(..)) throws *")
    public void log(ProceedingJoinPoint jp) throws Throwable {
        logs.info(jp.getSignature().toString() + ": Method Execution Started");
        Instant startTime = Instant.now();
        jp.proceed();
        Instant endTime = Instant.now();
        logs.info(jp.getSignature().toString() + ": Method Execution Completed");
        logs.info("Time Taken For Execution: " + Duration.between(startTime, endTime).toSeconds() + " seconds");
        logs.info("Time Taken For Execution: " + Duration.between(startTime, endTime).toMillis() + " milliseconds");
    }

//    @Around("execution(String _02__AOP_Terms.services.VehicleService.get*(..))")
//    public void log2(ProceedingJoinPoint jp) throws Throwable {
//        jp.proceed();
//        logs.info(jp.getSignature().toString() + ": Success");
//    }

}
