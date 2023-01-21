package hr.algebra.models;

public class Employee extends Person implements TerminalWorker {
    private final TerminalWorkerPosition employeeLevel;
    private double salary = 0D;

    public Employee(String firstName, String lastName, TerminalWorkerPosition employeeLevel) {
        super(firstName, lastName);
        this.employeeLevel = employeeLevel;
    }

    @Override
    public void fuelUpVehicle(Vehicle vehicle) {
        vehicle.setGasAmount(100);
    }

    @Override
    public boolean boardVehicle(Vehicle vehicle, Train train) {
        vehicle.drive();
        return train.addVehicle(vehicle);
    }

    @Override
    public TerminalWorkerPosition getTerminalWorkerPosition() {
        return employeeLevel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
