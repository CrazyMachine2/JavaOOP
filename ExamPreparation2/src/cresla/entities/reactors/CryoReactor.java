package cresla.entities.reactors;

public class CryoReactor extends ReactorImpl {
    private int cyroProductionIndex;

    public CryoReactor(int id, int cyroProductionIndex, int capacity) {
        super(id, capacity);
        this.cyroProductionIndex = cyroProductionIndex;
    }

    //TODO: Check it
    @Override
    public long getTotalEnergyOutput() {
//        if (super.getTotalEnergyOutput() * this.cyroProductionIndex > super.getTotalHeatAbsorbing()) {
//            return 0;
//        }

        return super.getTotalEnergyOutput() * this.cyroProductionIndex;
    }
}
