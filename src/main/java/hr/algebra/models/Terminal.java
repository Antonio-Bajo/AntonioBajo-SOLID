package hr.algebra.models;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Terminal {
    private final String name;
    private int revenue;
    private List<? extends TerminalWorker> terminalWorkers = new ArrayList<>();
    private List<Train> trains = new ArrayList<>();
    private int totalVehicleBoardedCount;

    public Terminal(String name) {
        this.name = name;
    }

    public List<? extends TerminalWorker> getTerminalWorkers() {
        return terminalWorkers;
    }

    public void setTerminalWorkers(List<? extends TerminalWorker> terminalWorkers) {
        this.terminalWorkers = terminalWorkers;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public boolean boardVehicle(Vehicle vehicle) {
        if (terminalWorkers.isEmpty() || trains.isEmpty()) {
            return false;
        }

        TerminalWorker worker = getRandomWorker();
        Optional<Train> train = getFirstFreeTrain(vehicle);


        if (train.isEmpty()) {
            return false;
        }

        System.out.println(vehicle.getName() + " gas amount before boarding " + vehicle.getGasAmount() + "%");

        switch (vehicle.getFuelType()) {
            case GAS, ELECTRIC -> {
                if (vehicle.getGasAmount() < 10) {
                    worker.fuelUpVehicle(vehicle);
                }
            }
            case PETROL, OTHER -> {
            }
        }

        if (!worker.boardVehicle(vehicle, train.get())) {
            return false;

        }

        System.out.println(vehicle.getName() + " gas amount after boarding " + vehicle.getGasAmount() + "%");
        System.out.println();

        if (worker instanceof Employee employee) {
            double bonus = 0;

            switch (employee.getTerminalWorkerPosition()) {
                case BASIC -> bonus = 0.10 * calculateTicketPrice(vehicle);

                case ADVANCED -> bonus = 0.11 * calculateTicketPrice(vehicle);
            }
            employee.setSalary(employee.getSalary() + bonus);
        }

        revenue += calculateTicketPrice(vehicle);
        totalVehicleBoardedCount++;

        return true;
    }

    Random random = new Random();

    private TerminalWorker getRandomWorker() {
        return terminalWorkers.get(random.nextInt(terminalWorkers.size()));
    }


    private Optional<Train> getFirstFreeTrain(Vehicle vehicle) {
        switch (vehicle.getVehicleCategory()) {
            case CLASS1, CLASS2 -> {
                return trains.stream()
                        .filter(t -> !t.isFull() && t.getTrainSize() == Train.TrainSize.SMALL)
                        .findFirst();
            }
            case CLASS4, CLASS5 -> {
                return trains.stream()
                        .filter(t -> !t.isFull() && t.getTrainSize() == Train.TrainSize.BIG)
                        .findFirst();
            }
        }

        return Optional.empty();
    }

    private int calculateTicketPrice(Vehicle vehicle) {
        switch (vehicle.getVehicleCategory()) {
            case CLASS1 -> {
                return 50;
            }
            case CLASS2 -> {
                return 80;
            }
            case CLASS4 -> {
                return 70;
            }
            case CLASS5 -> {
                return 90;
            }
        }
        return 0;
    }


    public String Report() {
        StringBuilder report = new StringBuilder();

        report
                .append("Report for " + this.name)
                .append(System.lineSeparator())
                .append("Total revenue from tickets: " + this.revenue + "$")
                .append(System.lineSeparator())
                .append("Total vehicles boarded: " + this.totalVehicleBoardedCount)
                .append(System.lineSeparator())
                .append("Employees: ")
                .append(System.lineSeparator());

        for (TerminalWorker terminalWorker : terminalWorkers) {
            if (terminalWorker instanceof Employee employee) {
                report
                        .append(employee.getFirstName() + " ")
                        .append(employee.getLastName() + " ")
                        .append("Money made from boarding vehicles: ")
                        .append(employee.getSalary() + "$  ")
                        .append(System.lineSeparator());
            }
        }
        return report.toString();
    }
}
