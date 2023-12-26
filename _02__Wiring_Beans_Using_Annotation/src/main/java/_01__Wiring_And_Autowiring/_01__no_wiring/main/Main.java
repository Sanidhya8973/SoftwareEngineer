package _01__Wiring_And_Autowiring._01__no_wiring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import _01__Wiring_And_Autowiring._01__no_wiring.config.ProjectConfig;
import _01__Wiring_And_Autowiring._01__no_wiring.beans.Person;
import _01__Wiring_And_Autowiring._01__no_wiring.beans.Vehicle;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle myVehicle = context.getBean(Vehicle.class);
        Person myPerson = context.getBean(Person.class);

        System.out.println("\n> Person Name : " + myPerson.getName());
        System.out.println("\n> Vehicle Name: " + myVehicle.getName());
        try {
            System.out.println("\n> " + myPerson.getName() + " owns " + myPerson.getVehicle().getName());
        } catch (Exception e) {
            System.out.println("\n> " + e);
        }

        context.close();
    }

}
