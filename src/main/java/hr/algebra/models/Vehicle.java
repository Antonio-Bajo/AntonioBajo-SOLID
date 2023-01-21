package hr.algebra.models;

public class Vehicle {
    private final String name;
    private final VehicleCategory vehicleCategory;
    private final FuelType fuelType;

    private int gasAmount;


    public Vehicle(String name, VehicleCategory vehicleCategory, FuelType fuelType) {
        this.name = name;
        this.vehicleCategory = vehicleCategory;
        this.fuelType = fuelType;
    }

    public void drive() {
        if (gasAmount > 0) {
            System.out.println("Car driving");
            gasAmount--;
        }
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        if (gasAmount < 0 || gasAmount > 100) {
            throw new RuntimeException("gas amount must be between 0 and 100");
        }
        this.gasAmount = gasAmount;
    }


    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public String getName() {
        return name;
    }


    public enum FuelType {
        GAS, ELECTRIC, PETROL, OTHER
    }
}
