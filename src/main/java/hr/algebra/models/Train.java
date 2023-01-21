package hr.algebra.models;

public class Train extends VehicleTransport {
    private final TrainSize trainSize;

    private final String name;

    public Train(TrainSize trainSize, String name) {
        this.trainSize = trainSize;
        this.name = name;

        switch (trainSize) {
            case SMALL -> this.vehicleCapacity = 8;
            case BIG -> this.vehicleCapacity = 6;
        }

    }

    public boolean isFull() {
        return vehicleList.size() >= vehicleCapacity;
    }


    @Override
    public boolean addVehicle(Vehicle vehicle) {
        boolean rightVehicleCategory = false;
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();

        switch (trainSize) {
            case SMALL -> {
                if (vehicleCategory == VehicleCategory.CLASS1 || vehicleCategory == VehicleCategory.CLASS2) {
                    rightVehicleCategory = true;

                }
            }
            case BIG -> {
                if (vehicleCategory == VehicleCategory.CLASS5 || vehicleCategory == VehicleCategory.CLASS4) {
                    rightVehicleCategory = true;

                }
            }
        }

        return rightVehicleCategory && super.addVehicle(vehicle);
    }

    public TrainSize getTrainSize() {
        return trainSize;
    }

    public enum TrainSize {
        SMALL, BIG
    }


}
