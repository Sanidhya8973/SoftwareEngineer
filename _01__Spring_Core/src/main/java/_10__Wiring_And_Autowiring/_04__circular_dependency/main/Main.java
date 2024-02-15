package _10__Wiring_And_Autowiring._04__circular_dependency.main;

import _10__Wiring_And_Autowiring._04__circular_dependency.beans.Person;
import _10__Wiring_And_Autowiring._04__circular_dependency.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person myPerson = context.getBean(Person.class);

        System.out.println("\n> Person  Name: " + myPerson.getName());
        System.out.println("\n> Vehicle Name: " + myPerson.getVehicle().getName());
        System.out.println("\n> " + myPerson.getName() + " owns " + myPerson.getVehicle().getName());

        context.close();
    }

}

// A Circular Dependency will happen if 2 beans are waiting for each other to create inside the Spring Context in order to do auto-wiring.
// Consider the below scenario where Person has a dependency on Vehicle Class and Vehicle Class has a dependency on Person Class.
// In such scenarios, Spring will throw "UnsatisfiedDependencyException" due to a circular reference.
// As a developer, it is our responsibility to make sure we are defining the configurations/dependencies that will result in circular dependencies.
