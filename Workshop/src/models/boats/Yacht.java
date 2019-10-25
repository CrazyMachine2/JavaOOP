package models.boats;

import contracts.BoatEngine;

public class Yacht extends MotorBoat {
    private int cargoWeight;

    public Yacht(String model, int weight,BoatEngine engine, int cargoWeight) {
        super(model, weight, engine);
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        if(cargoWeight < 1){
            throw new IllegalArgumentException("Cargo Weight must be a positive integer.");
        }
        this.cargoWeight = cargoWeight;
    }
}
