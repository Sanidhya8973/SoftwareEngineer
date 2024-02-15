package _02__AOP_Terms.model.aspects;

import org.apache.log4j.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Order(1)
@Component
public class LoggerAspect {

    private static final Logger logs = Logger.getLogger(LoggerAspect.class);

    public LoggerAspect() {
        Layout layout = new SimpleLayout();
        Appender appender = new ConsoleAppender(layout);
        logs.addAppender(appender);
    }

    // -----------------------------------------
    // | Ways To Configure Advice Inside AOP:- |
    // | 1) execution expression approach      |
    // | 2) annotation approach                |
    // -----------------------------------------

    // Method-1:-
    // @Before("execution(public void _02__AOP_Terms.services.VehicleService.*(..)) && args(vehicleStarted,..)")
    // Method-2:-
    // 1)value 2)argNames , argNames = "vehicleStarted"
    // @Before(value = "execution(public * _02__AOP_Terms.services.VehicleService.*(..))", argNames = "vehicleStarted") // not working, I have to refer docs
    @Before("execution(public void _02__AOP_Terms.services.VehicleService.*(..)) && args(vehicleStarted,..)")
    public void checkVehicleEngineLoggerAspectClass(JoinPoint jp, Boolean vehicleStarted) {
        if (!vehicleStarted) {
            logs.warn("Engine Of The Vehicle: OFF");
            throw new RuntimeException("Engine Of The Vehicle: OFF");
        } else {
            logs.info("Engine Of The Vehicle: ON");
        }
    }

    @Around("execution(public * _02__AOP_Terms.services.VehicleService.*(..))")
    public void logAround(ProceedingJoinPoint pjp) throws Throwable {
        logs.info(pjp.getSignature().toString() + ": Method Execution Started");
        Instant startTime = Instant.now();
        pjp.proceed(); // throws Throwable
        Instant endTime = Instant.now();
        logs.info(pjp.getSignature().toString() + ": Method Execution Completed");
        logs.info("Time Taken For Execution: " + Duration.between(startTime, endTime).toSeconds() + " seconds");
        logs.info("Time Taken For Execution: " + Duration.between(startTime, endTime).toMillis() + " milliseconds");
    }

    @Around("@annotation(_02__AOP_Terms.model.annotations.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        logs.info(pjp.getSignature().toString() + ": Method Execution Started   // logs generated through annotation approach");
        Instant startTime = Instant.now();
        pjp.proceed(); // throws Throwable
        Instant endTime = Instant.now();
        logs.info(pjp.getSignature().toString() + ": Method Execution Completed // logs generated through annotation approach");
        logs.info("// logs generated through annotation approach \n       Time Taken For Execution: " + Duration.between(startTime, endTime).toSeconds() + " seconds");
        logs.info("// logs generated through annotation approach \n       Time Taken For Execution: " + Duration.between(startTime, endTime).toMillis() + " milliseconds");
    }

    // 1)value 2)argNames 3)throwing 4)pointcut
    @AfterThrowing(value = "execution(public String _02__AOP_Terms.services.VehicleService.*(..))", throwing = "e")
    public void logException(JoinPoint jp, Exception e) {
        logs.warn("WARN MESSAGE: " + e.getMessage());
        logs.warn("STACK TRACE :" + e.getStackTrace());
    }

    // 1)value 2)argNames 3)returning 4)pointcut
    @AfterReturning(value = "execution(public String _02__AOP_Terms.services.VehicleService.getVehicleServiceSummary(..))", returning = "returnValue")
    public void logStatus(JoinPoint jp, Object returnValue) {
        logs.info("RETURN VALUE:" + returnValue.toString());
    }

    @AfterReturning(value = "execution(public String _02__AOP_Terms.services.VehicleService.getSpeakersData())", returning = "returnValue")
    public void logSpeakersStatus(JoinPoint jp, Object returnValue) {
        logs.info("RETURN VALUE:" + returnValue.toString());
        System.out.println("> SPEAKERS: " + returnValue);
    }

    @AfterReturning(value = "execution(public String _02__AOP_Terms.services.VehicleService.getTyresData())", returning = "returnValue")
    public void logTyresStatus(JoinPoint jp, Object returnValue) {
        logs.info("RETURN VALUE:" + returnValue.toString());
        System.out.println("> Tyres: " + returnValue);
    }

}
