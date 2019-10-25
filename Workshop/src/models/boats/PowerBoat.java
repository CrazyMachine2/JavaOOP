package models.boats;

import contracts.BoatEngine;

public class PowerBoat extends MotorBoat {
    private BoatEngine secondBoatEngine;

    public PowerBoat(String model, int weight, BoatEngine firstBoatEngine, BoatEngine secondBoatEngine) {
        super(model, weight,firstBoatEngine);
        this.secondBoatEngine = secondBoatEngine;
    }
}
