package _03__Custom_Name_To_The_Bean.main;

import _03__Custom_Name_To_The_Bean.beans.Vehicle;
import _03__Custom_Name_To_The_Bean.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle myVehicle1 = context.getBean("fordVehicle", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle1.getName());

        Vehicle myVehicle2 = context.getBean("hondaVehicle", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle2.getName());

        Vehicle myVehicle3 = context.getBean("lamborghiniVehicle", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle3.getName());

        // It will throw an exception...
        // myVehicle1 = context.getBean("vehicle1", Vehicle.class);
        // System.out.println("\n> Vehicle name from Spring Context: " + myVehicle1.getName());
    }

}
