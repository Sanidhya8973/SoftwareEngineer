package _15__Lazy_Instantiation.main;

import _15__Lazy_Instantiation.beans.Person;
import _15__Lazy_Instantiation.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("> before retrieving the Person.java bean from the Spring Context");
        Person myPerson = context.getBean(Person.class);
        System.out.println("> after retrieving the Person.java bean from the Spring Context");
        System.out.println("> Car: " + myPerson.getVehicle().getName() + ", Owner: " + myPerson.getName());
        System.out.println();
        System.out.println("------------------");
        System.out.println("LAZY INSTANTIATION");
        System.out.println("------------------");
        System.out.println("> When we change the default behavior to initialize the Singleton Beans LAZILY only when the application is trying to refer to the bean.");
        System.out.println("> This is called Lazy Instantiation.");
        System.out.println("> Syntax: @Lazy // add this annotation on the top of the class of which you want to create a bean");
    }

}
