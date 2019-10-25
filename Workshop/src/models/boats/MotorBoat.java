package models.boats;

import contracts.BoatEngine;
import core.Engine;

public abstract class MotorBoat extends BoatImpl{
    private BoatEngine engine;


    protected MotorBoat(String model, int weight, BoatEngine engine) {
        super(model, weight);
        this.engine = engine;
    }
}
