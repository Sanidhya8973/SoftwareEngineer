package _02__AOP_Terms.model.beans;

import _02__AOP_Terms.services.VehicleService;
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
