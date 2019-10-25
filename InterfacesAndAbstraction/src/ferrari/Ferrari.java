package ferrari;

public class Ferrari implements Car {
    private static final String FERARRI_MODEL = "488-Spider";

    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = Ferrari.FERARRI_MODEL;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model,this.brakes(),this.gas(),this.driverName);
    }
}
