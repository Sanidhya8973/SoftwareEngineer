package _01__Create_Beans_Using_Annotation.main;

// There are 2 types of Spring IoC Containers...
// 1) import org.springframework.beans.factory.BeanFactory;                (fewer features)
// 2) import org.springframework.context.ApplicationContext; (recommended) (more  features)

import _01__Create_Beans_Using_Annotation.beans.Vehicle;
import _01__Create_Beans_Using_Annotation.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Normally, we create a variable like this...
        Vehicle myVehicle1 = new Vehicle();
        myVehicle1.setName("HONDA");
        System.out.println("\n> Vehicle name from Non-Spring Context: " + myVehicle1.getName());

        // The var keyword was introduced in JAVA 10.
        // Type Inference is used in var keyword in which it detects automatically the datatype of a variable based on the surrounding context.

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle myVehicle2 = context.getBean(Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle2.getName());

        // We don't need to do any explicit casting while fetching a bean from context.
        // Spring is smart enough to look for a bean of the type you requested in its context.
        // If such a bean doesn't exist, Spring will throw an exception.

        String greet = context.getBean(String.class);
        System.out.println("\n> String value from Spring Context: " + greet);
        Integer number = context.getBean(Integer.class);
        System.out.println("\n> Integer value from Spring Context: " + number);

        // NOTE:-
        // Earlier, we used to write below given code...
        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // After JAVA 10, we use to write the same code as given below...
        // var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }

}
