package _10__Wiring_And_Autowiring._02__wiring.main;

import _10__Wiring_And_Autowiring._02__wiring.beans.Person;
import _10__Wiring_And_Autowiring._02__wiring.beans.Vehicle;
import _10__Wiring_And_Autowiring._02__wiring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle myVehicle = context.getBean(Vehicle.class);
        Person myPerson = context.getBean(Person.class);

        System.out.println("\n> Person Name : " + myPerson.getName());
        System.out.println("\n> Vehicle Name: " + myVehicle.getName());
        System.out.println("\n> " + myPerson.getName() + " owns " + myPerson.getVehicle().getName());

        context.close();
    }

}
