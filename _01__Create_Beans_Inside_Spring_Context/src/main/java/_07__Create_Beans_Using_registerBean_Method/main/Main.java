package _07__Create_Beans_Using_registerBean_Method.main;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import _07__Create_Beans_Using_registerBean_Method.config.ProjectConfig;
import _07__Create_Beans_Using_registerBean_Method.beans.Vehicle;
import java.util.Random;
import java.util.function.Supplier;

// Sometimes we want to create new instances of an object and add them into the Spring Context based on a programming condition.
// For the same, from Spring 5 version, a new approach is provided to create the beans programmatically by invoking the registerBean() method.
// The registerBean() method is present inside the context object.

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // import java.util.function.Supplier;
        Supplier<Vehicle> fordSupplier = () -> {
            Vehicle ford = new Vehicle();
            ford.setName("FORD");
            return ford;
        };

        // import java.util.function.Supplier;
        Supplier<Vehicle> hondaSupplier = () -> {
            Vehicle honda = new Vehicle();
            honda.setName("HONDA");
            return honda;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10); // returns any number from 0 to 9 i.e. 0 (inclusive) and 10 (exclusive)
        System.out.println("\n> The Chosen One: " + randomNumber);

        if ((randomNumber % 2) == 0) {
            context.registerBean("ford", Vehicle.class, fordSupplier);
        } else {
            context.registerBean("honda", Vehicle.class, hondaSupplier);
        }

        Vehicle fordVehicle = null;
        Vehicle hondaVehicle = null;
        try {
            fordVehicle = context.getBean("ford", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) { // import org.springframework.beans.factory.NoSuchBeanDefinitionException;
            System.out.println("\n> Error while creating ford vehicle...");
        }
        try {
            hondaVehicle = context.getBean("honda", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) { // import org.springframework.beans.factory.NoSuchBeanDefinitionException;
            System.out.println("\n> Error while creating honda vehicle...");
        }

        // Performing the null check...
        if (null != fordVehicle) {
            System.out.println("\n> Programming Vehicle name from Spring Context: " + fordVehicle.getName());
        } else {
            System.out.println("\n> Programming Vehicle name from Spring Context: " + hondaVehicle.getName());
        }

        context.close();
    }

}
