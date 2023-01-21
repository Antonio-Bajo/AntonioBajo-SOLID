package hr.algebra.models;


import java.util.LinkedList;
import java.util.List;

public abstract class VehicleTransport {
    protected int vehicleCapacity;
    protected List<Vehicle> vehicleList = new LinkedList<>();

    public VehicleTransport() {
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicleList.size() > vehicleCapacity) {
            return false;
        }
        return vehicleList.add(vehicle);
    }

    ;

}
