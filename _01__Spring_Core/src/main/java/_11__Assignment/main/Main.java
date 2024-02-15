package _11__Assignment.main;

import _11__Assignment.config.ProjectConfig;
import _11__Assignment.model.beans.Person;
import _11__Assignment.model.beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        String[] persons = context.getBeanNamesForType(Person.class);
        String[] vehicles = context.getBeanNamesForType(Vehicle.class);
        Person myPerson = context.getBean(Person.class);
        Vehicle myVehicle = context.getBean(Vehicle.class);

        String owner = myPerson.getName();
        String ownerVehicle = myPerson.getVehicle().getName();
        String speakers = myPerson.getVehicle().getVehicleServices().getSpeakers().getName();
        String tyres = myPerson.getVehicle().getVehicleServices().getTyres().getName();

        System.out.println("\n> OWNERSHIP CHECK:-");
        System.out.println("- " + owner + " Owns A " + ownerVehicle + " Which Has " + speakers + " Sound System And " + tyres + " Tyres.");
        System.out.println("\n> STATUS CHECK:-");
        // METHOD-1
        myPerson.getVehicle().getVehicleServices().playMusic();
        myPerson.getVehicle().getVehicleServices().carGrip();
        // METHOD-2
        // myVehicle.getVehicleServices().playMusic();
        // myVehicle.getVehicleServices().carGrip();

        context.close();
    }

}
