package models.engines;

import contracts.BoatEngine;

public abstract class BoatEngineImpl implements BoatEngine {
    private String model;
    private int horsePower;
    private int displacement;
    private int output;

    protected BoatEngineImpl(String model, int horsePower, int displacement) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setDisplacement(displacement);
        this.setOutput(horsePower, displacement);
    }

    protected void setModel(String model) {
        if(model.length() < 3){
            throw new IllegalArgumentException("Model's name must be at least 3 symbols long.");
        }
        this.model = model;
    }

    protected void setHorsePower(int horsePower) {
        if (horsePower < 1){
            throw new IllegalArgumentException("Horsepower must be a positive integer.");
        }
        this.horsePower = horsePower;
    }

    protected void setDisplacement(int displacement) {
        if (displacement < 1){
            throw new IllegalArgumentException("Displacement must be a positive integer.");
        }
        this.displacement = displacement;
    }

    protected void setOutput(int horsePower, int displacement){
        this.output = this.calculateOutput(horsePower, displacement);
    }

    @Override
    public abstract int calculateOutput(int horsePower, int displacement);

    @Override
    public String getModel(){
        return this.model;
    }
}
