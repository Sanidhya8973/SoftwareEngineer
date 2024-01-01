package _01__Understand_Problems_In_WebApp_Without_AOP.main;

import _01__Understand_Problems_In_WebApp_Without_AOP.config.ProjectConfig;
import _01__Understand_Problems_In_WebApp_Without_AOP.model.beans.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean("person", Person.class);
        System.out.println("> OWNER  : " + person.getName());
        System.out.println("> VEHICLE: " + person.getVehicle().getName());
        System.out.println("> VEHICLE STATUS:-");
        person.getVehicle().getVehicleService().playMusic(true);
        person.getVehicle().getVehicleService().carGripOn(true);
        person.getVehicle().getVehicleService().carGripOff(true);
    }

}
