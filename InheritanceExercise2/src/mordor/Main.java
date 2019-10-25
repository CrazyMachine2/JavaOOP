package mordor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] foods = scan.nextLine().split(" ");
        Gandalf gandalf = new Gandalf();

        for (String food : foods) {
            gandalf.eatFood(food);
        }

        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());


    }
}
