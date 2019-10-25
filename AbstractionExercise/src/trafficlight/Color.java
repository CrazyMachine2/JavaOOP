package trafficlight;

public enum Color {
    RED(0),
    GREEN(1),
    YELLOW(2);

    private int value;

    Color(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
