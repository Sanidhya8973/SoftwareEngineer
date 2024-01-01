package _01__Understand_Problems_In_WebApp_Without_AOP.main;

import _01__Understand_Problems_In_WebApp_Without_AOP.config.ProjectConfig;
import _01__Understand_Problems_In_WebApp_Without_AOP.model.beans.Person;
import _01__Understand_Problems_In_WebApp_Without_AOP.model.beans.Song;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean("person", Person.class);
        System.out.println("> OWNER  : " + person.getName());
        System.out.println("> VEHICLE: " + person.getVehicle().getName());
        System.out.println("> VEHICLE STATUS:-");
        boolean isVehicleOn = true;
        person.getVehicle().getVehicleService().playMusic(isVehicleOn, new Song("valid-song-name","valid-singer-name"));
        person.getVehicle().getVehicleService().carGripOn(isVehicleOn);
        person.getVehicle().getVehicleService().carGripOff(isVehicleOn);
    }

}
