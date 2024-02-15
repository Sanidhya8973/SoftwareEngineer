package _14__Eager_Instantiation.main;

import _14__Eager_Instantiation.beans.Person;
import _14__Eager_Instantiation.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("> before retrieving the Person.java bean from the Spring Context");
        Person myPerson = context.getBean(Person.class);
        System.out.println("> after retrieving the Person.java bean from the Spring Context");
        System.out.println("> Car: " + myPerson.getVehicle().getName() + ", Owner: " + myPerson.getName());
        System.out.println();
        System.out.println("-------------------");
        System.out.println("EAGER INSTANTIATION");
        System.out.println("-------------------");
        System.out.println("> By Default Spring Framework Supports Eager Instantiation.");
        System.out.println("> By default Spring will create all Singleton Beans eagerly during the startup of the application itself.");
        System.out.println("> This is called Eager Instantiation.");
    }

}
