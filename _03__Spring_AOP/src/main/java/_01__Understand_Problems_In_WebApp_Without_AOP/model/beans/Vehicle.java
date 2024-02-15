package _01__Understand_Problems_In_WebApp_Without_AOP.model.beans;

import _01__Understand_Problems_In_WebApp_Without_AOP.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

    private String name;
    private final VehicleService vehicleService;

    @Autowired
    public Vehicle(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        setName("LEXUS LFA");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }

}
