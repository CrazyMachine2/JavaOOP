package cardsuit;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;

    CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Ordinal value: ");
        sb.append(this.value + "; ");
        sb.append("Name value: ");
        sb.append(this.name());

        return sb.toString();
    }
}
