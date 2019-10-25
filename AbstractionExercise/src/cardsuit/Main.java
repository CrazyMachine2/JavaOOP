package cardsuit;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CardRank rank = CardRank.valueOf(scan.nextLine());
        CardSuit suit = CardSuit.valueOf(scan.nextLine());
        Card card = new Card(rank,suit);

        System.out.println(card.toString());

//        System.out.println("Card Suits:");
//        for(CardSuit cardsuit : CardSuit.values()){
//            System.out.println(cardsuit.toString());
//        }

//        System.out.println("Card Ranks:");
//        for (CardRank card : CardRank.values()){
//            System.out.println(card.toString());
//        }
    }
}
