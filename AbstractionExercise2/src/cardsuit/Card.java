package cardsuit;

public class Card {
    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank rank, CardSuit suit){
        this.rank = rank;
        this.suit = suit;
        setPower(this.rank.getValue(),this.suit.getValue());
    }

    private void setPower(int rankPower, int suitPower) {
        this.power = rankPower + suitPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d%n"
                ,this.rank.name(),this.suit.name(),this.power);
    }
}
