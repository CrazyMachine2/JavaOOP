package pizzacalories;

public enum FlourType {
    White(1.5),
    Wholegrain(1.0);

    private double value;

    FlourType(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
