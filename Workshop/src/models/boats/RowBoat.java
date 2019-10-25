package models.boats;

public class RowBoat extends BoatImpl {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    protected void setOars(int oars) {
        if(oars < 1){
            throw new IllegalArgumentException("Oars must be a positive integer.");
        }
    }
}
