package vehicles;

import java.text.DecimalFormat;

public class Bus extends VehicleImpl {

    public Bus(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + 1.4);
    }

    @Override
    public String driveWithPeople(double distance) {
        return super.driveWithPeople(distance);
    }

    @Override
    public String driveWithoutPeople(double distance) {
        double consumedFuel = (this.getFuelConsumptionPerKilometer() - 1.4) * distance;
        String result = String.format("%s needs refueling",this.getClass().getSimpleName());

        if (this.getFuelQuantity() - consumedFuel > 0) {
            this.setFuelQuantity(this.getFuelQuantity() - consumedFuel);
            DecimalFormat df = new DecimalFormat("#.##");
            result = String.format("Bus travelled %s km", df.format(distance));
        }
        return result;
    }

    @Override
    public void refuel(double fuel) {
       super.refuel(fuel);
    }
}
