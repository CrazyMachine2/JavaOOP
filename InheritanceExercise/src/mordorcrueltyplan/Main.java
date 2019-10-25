package mordorcrueltyplan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Gandalf theGrey = new Gandalf();
        String[] data = scan.nextLine().split(" ");

        for (String food : data) {
            theGrey.eatFood(food);
        }

        System.out.println(theGrey.getFoodPoints());
        System.out.println(theGrey.getMood());
    }
}
