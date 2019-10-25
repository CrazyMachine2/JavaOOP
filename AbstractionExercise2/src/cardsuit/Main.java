package cardsuit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        CardRank rank = CardRank.valueOf(scan.nextLine());
        CardSuit suit = CardSuit.valueOf(scan.nextLine());

        Card card = new Card(rank, suit);

        System.out.println(card);
////
//        System.out.println("Card Ranks:");
//        for (CardRank cardRank : CardRank.values()){
//            System.out.println(cardRank.toString());
//             System.out.println(cardRank.ordinal())
//        }

//        System.out.println("Card Suits:");
//        for (CardSuit cardSuit : CardSuit.values()){
//            System.out.println(cardSuit.toString());
//        }
    }
}

