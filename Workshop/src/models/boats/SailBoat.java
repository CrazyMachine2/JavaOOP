package models.boats;

public class SailBoat extends BoatImpl {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if(sailEfficiency < 1 || sailEfficiency > 100){
            throw new IllegalArgumentException("Sail Effectiveness must be between [1...100].");
        }
        this.sailEfficiency = sailEfficiency;
    }
}
