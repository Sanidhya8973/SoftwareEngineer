package _01__Types_Of_Beans_Scope._1__Singleton_Beans_Scope.main;

import _01__Types_Of_Beans_Scope._1__Singleton_Beans_Scope.beans.Vehicle;
import _01__Types_Of_Beans_Scope._1__Singleton_Beans_Scope.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle myVehicle0 = context.getBean(Vehicle.class);
        Vehicle myVehicle1 = context.getBean("vehicle1", Vehicle.class);
        Vehicle myVehicle2 = context.getBean("vehicle2", Vehicle.class);
        Vehicle myVehicle3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("-----------------------");
        System.out.println("> SINGLETON BEANS SCOPE");
        System.out.println("-----------------------");
        System.out.println("> Object-0 -> HashCode: " + myVehicle0.hashCode() + ", Name: " + myVehicle0.getName());
        System.out.println("> Object-1 -> HashCode: " + myVehicle1.hashCode() + ", Name: " + myVehicle1.getName());
        System.out.println("> Object-2 -> HashCode: " + myVehicle2.hashCode() + ", Name: " + myVehicle2.getName());
        System.out.println("> Object-3 -> HashCode: " + myVehicle3.hashCode() + ", Name: " + myVehicle3.getName());
        System.out.println("------------");
        System.out.println("VERIFICATION");
        System.out.println("------------");
        if (myVehicle0.hashCode() == myVehicle1.hashCode()) {
            System.out.println("> Verify-1: myVehicle0.hashCode() == myVehicle1.hashCode()");
            System.out.println("> Both The HashCodes Are Same, i.e. Same Instance Is Being Used. So, It's Singleton Beans Scope.");
        }
        if (myVehicle1.hashCode() != myVehicle2.hashCode() || myVehicle2.hashCode() != myVehicle3.hashCode() || myVehicle1.hashCode() != myVehicle3.hashCode()) {
            System.out.println("> Verify-2: myVehicle1.hashCode() != myVehicle2.hashCode() || myVehicle2.hashCode() != myVehicle3.hashCode() || myVehicle1.hashCode() != myVehicle3.hashCode()");
            System.out.println("> There is only 1 instance for multiple beans of same type.");
        }
    }

}
