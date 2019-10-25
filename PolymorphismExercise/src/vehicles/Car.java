package vehicles;

public class Car extends VehicleImpl {


    public Car(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + 0.9);
    }

    @Override
    public String driveWithPeople(double distance) {
        return super.driveWithPeople(distance);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel);
    }

    @Override
    public String driveWithoutPeople(double distance) {
        return null;
    }
}
