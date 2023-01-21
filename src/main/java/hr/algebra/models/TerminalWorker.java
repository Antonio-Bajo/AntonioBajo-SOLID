package hr.algebra.models;

public interface TerminalWorker {
    void fuelUpVehicle(Vehicle vehicle);

    boolean boardVehicle(Vehicle vehicle, Train train);

    TerminalWorkerPosition getTerminalWorkerPosition();
}

