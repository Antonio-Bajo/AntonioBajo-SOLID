package hr.algebra;

import hr.algebra.models.*;
import hr.algebra.repository.Database;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


public class Solid {
    public static void main(String[] args) {
        Random random = new Random();

        List<Employee> employees = Database.getEmployees();
        List<Train> trains = Database.getTrains();
        Queue<Vehicle> vehicleQueue = new LinkedList<>(Database.getVehicles());
        vehicleQueue.forEach(v -> v.setGasAmount(random.nextInt(100)));

        Terminal terminal = new Terminal("Terminal d.o.o.");
        terminal.setTrains(trains);
        terminal.setTerminalWorkers(employees);


        while(!vehicleQueue.isEmpty()){
            Vehicle vehicle = vehicleQueue.element();

            if (!terminal.boardVehicle(vehicle)){
                System.out.println("Terminal currently cannot board this vehicle.");
            }

            vehicleQueue.remove();
        }

        System.out.println(terminal.Report());
    }
}
