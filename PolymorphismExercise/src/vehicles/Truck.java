package vehicles;

public class Truck extends VehicleImpl {


    public Truck(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + 1.6);
    }

    @Override
    public String driveWithPeople(double distance) {
       return super.driveWithPeople(distance);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel-(fuel * 0.05));
    }

    @Override
    public String driveWithoutPeople(double distance) {
        return null;
    }
}
