package _06__PostConstruct_PreDestroy_Annotations.main;

import _06__PostConstruct_PreDestroy_Annotations.beans.Vehicle;
import _06__PostConstruct_PreDestroy_Annotations.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle myVehicle = context.getBean(Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context using @PostConstruct Annotation: " + myVehicle.getName());

        context.close();
    }

}