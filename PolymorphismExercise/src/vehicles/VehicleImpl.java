package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;
    private double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumptionPerKilometer() {
        return this.fuelConsumptionPerKilometer;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity){
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String driveWithPeople(double distance){
        double consumedFuel = this.fuelConsumptionPerKilometer * distance;
        String result = String.format("%s needs refueling",this.getClass().getSimpleName());

        if(this.fuelQuantity - consumedFuel > 0){
            this.fuelQuantity -= consumedFuel;
            DecimalFormat df = new DecimalFormat("#.##");
            result =  String.format("%s travelled %s km",this.getClass().getSimpleName(),df.format(distance));
        }

        return result;
    };

    @Override
    public void refuel(double fuel){
        if (this.fuelQuantity + fuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity += fuel;
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
