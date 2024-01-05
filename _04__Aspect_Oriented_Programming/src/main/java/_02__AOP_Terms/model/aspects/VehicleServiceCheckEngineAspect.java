package _02__AOP_Terms.model.aspects;

import org.apache.log4j.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class VehicleServiceCheckEngineAspect {

    public static final Logger logs = Logger.getLogger(VehicleServiceCheckEngineAspect.class);

    public VehicleServiceCheckEngineAspect() {
        Layout layout = new SimpleLayout();
        Appender appender = new ConsoleAppender(layout);
        logs.addAppender(appender);
    }

    @Before("execution(public void _02__AOP_Terms.services.VehicleService.*(..)) && args(vehicleStarted,..))")
    public void checkVehicleEngine(JoinPoint jp, Boolean vehicleStarted) throws Throwable {
        if (!vehicleStarted) {
            logs.warn("Engine Of The Vehicle: OFF");
            throw new RuntimeException("Engine Of The Vehicle: OFF");
        } else {
            logs.info("Engine Of The Vehicle: ON");
        }
    }

}
