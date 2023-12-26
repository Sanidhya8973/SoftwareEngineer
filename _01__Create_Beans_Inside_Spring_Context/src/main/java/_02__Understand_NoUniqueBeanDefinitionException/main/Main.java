package _02__Understand_NoUniqueBeanDefinitionException.main;

// There are 2 types of Spring IoC Containers...
// 1) import org.springframework.beans.factory.BeanFactory;                (fewer features)
// 2) import org.springframework.context.ApplicationContext; (recommended) (more  features)

import _02__Understand_NoUniqueBeanDefinitionException.beans.Vehicle;
import _02__Understand_NoUniqueBeanDefinitionException.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // The var keyword was introduced in JAVA 10.
        // Type inference is used in var keyword in which it detects automatically the datatype of a variable based on the surrounding context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        // Exception Occurs
//        Vehicle myVehicle = context.getBean(Vehicle.class);
//        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle.getName());

        Vehicle myVehicle1 = context.getBean("vehicle1", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle1.getName());

        Vehicle myVehicle2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle2.getName());

        Vehicle myVehicle3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle3.getName());

        // We don't need to do any explicit casting while fetching a bean from context.
        // Spring is smart enough to look for a bean of the type you requested in its context.
        // If such a bean doesn't exist, Spring will throw an exception.
    }

}
