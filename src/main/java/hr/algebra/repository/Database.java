package hr.algebra.repository;

import hr.algebra.models.*;

import java.util.*;


public class Database {

    private Database(){}

    public static List<Train> getTrains() {
        return List.of(
                new Train(Train.TrainSize.SMALL, "Big Train #1"),
                new Train(Train.TrainSize.SMALL, "Big Train #2"),
                new Train(Train.TrainSize.SMALL, "Big Train #3"),

                new Train(Train.TrainSize.BIG, "Small Train #1"),
                new Train(Train.TrainSize.BIG, "Small Train #2"),
                new Train(Train.TrainSize.BIG, "Small Train #3"));
    }

    public static List<Employee> getEmployees() {
        return List.of(
                new Employee("Lucas","Jolie", TerminalWorkerPosition.BASIC),
                new Employee("Jack","Po", TerminalWorkerPosition.BASIC),
                new Employee("Lea","Roberts", TerminalWorkerPosition.ADVANCED),
                new Employee("Marc","Parker", TerminalWorkerPosition.ADVANCED));
    }

    public static List<Vehicle> getVehicles() {
        return List.of(
                new Vehicle("Tesla Model1", VehicleCategory.CLASS1, Vehicle.FuelType.ELECTRIC),
                new Vehicle("Tesla Model2", VehicleCategory.CLASS1, Vehicle.FuelType.ELECTRIC),
                new Vehicle("Tesla Model3", VehicleCategory.CLASS1, Vehicle.FuelType.ELECTRIC),
                new Vehicle("Tesla Model4",VehicleCategory.CLASS1, Vehicle.FuelType.ELECTRIC),

                new Vehicle("Volvo Van Model 1",VehicleCategory.CLASS2, Vehicle.FuelType.GAS),
                new Vehicle("Volvo Van Model 2",VehicleCategory.CLASS2, Vehicle.FuelType.GAS),
                new Vehicle("Volvo Van Model 3",VehicleCategory.CLASS2, Vehicle.FuelType.GAS),
                new Vehicle("Volvo Van Model 4",VehicleCategory.CLASS2, Vehicle.FuelType.GAS),

                new Vehicle("Mercedes Bus Model 1",VehicleCategory.CLASS4, Vehicle.FuelType.GAS),
                new Vehicle("Mercedes Bus Model 2",VehicleCategory.CLASS4, Vehicle.FuelType.GAS),
                new Vehicle("Mercedes Bus Model 3",VehicleCategory.CLASS4, Vehicle.FuelType.ELECTRIC),
                new Vehicle("Mercedes Bus Model 4",VehicleCategory.CLASS4, Vehicle.FuelType.ELECTRIC),

                new Vehicle("Tesla Truck Model 1",VehicleCategory.CLASS5, Vehicle.FuelType.ELECTRIC),
                new Vehicle("Tesla Truck Model 2",VehicleCategory.CLASS5, Vehicle.FuelType.ELECTRIC),
                new Vehicle("Tesla Truck Model 3",VehicleCategory.CLASS5, Vehicle.FuelType.ELECTRIC),
                new Vehicle("Tesla Truck Model 4",VehicleCategory.CLASS5, Vehicle.FuelType.ELECTRIC));
    }
}
