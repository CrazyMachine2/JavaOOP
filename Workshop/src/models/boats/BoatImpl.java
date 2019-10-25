package models.boats;

import contracts.Boat;

public abstract class BoatImpl implements Boat {
    private String model;
    private int weight;

    protected BoatImpl (String model, int weight){
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    protected void setModel(String model) {
        if(model.length() < 5){
            throw new IllegalArgumentException("Model's name must be at least 5 symbols long.");
        }

        this.model = model;
    }

    protected void setWeight(int weight) {
        if(weight < 1){
            throw new IllegalArgumentException("Weight must be a positive integer.");
        }
        this.weight = weight;
    }
}
