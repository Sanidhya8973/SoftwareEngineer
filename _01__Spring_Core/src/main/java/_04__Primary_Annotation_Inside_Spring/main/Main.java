package _04__Primary_Annotation_Inside_Spring.main;

import _04__Primary_Annotation_Inside_Spring.beans.Vehicle;
import _04__Primary_Annotation_Inside_Spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // If we do not pass any argument, then it will return the object of the method which has @Primary annotation...
        // This @Primary annotation will avoid the NoUniqueBeanDefinitionException by returning the object of the method with @Primary annotation...
        Vehicle myVehicle1 = context.getBean(Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle1.getName());

        Vehicle myVehicle2 = context.getBean("hondaVehicle", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle2.getName());

        Vehicle myVehicle3 = context.getBean("lamborghiniVehicle", Vehicle.class);
        System.out.println("\n> Vehicle name from Spring Context: " + myVehicle3.getName());
    }

}
