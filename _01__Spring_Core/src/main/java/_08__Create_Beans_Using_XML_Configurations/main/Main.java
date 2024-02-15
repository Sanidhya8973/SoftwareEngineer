package _08__Create_Beans_Using_XML_Configurations.main;

import _08__Create_Beans_Using_XML_Configurations.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("beans.xml");

        Vehicle myVehicle = context.getBean(Vehicle.class);
        System.out.println("\n> Creating Bean using XML: " + myVehicle.getName());
    }

}
