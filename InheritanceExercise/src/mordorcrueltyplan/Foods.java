package mordorcrueltyplan;

public enum Foods {
    Cram(2),
    Lembas(3),
    Apple(1),
    Melon(1),
    HoneyCake(5),
    Mushrooms(-10);

    private int value;

    Foods(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
