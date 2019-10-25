package telephony;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(" ");
        String[] urls = scan.nextLine().split(" ");

        LinkedList<String> numbersList = new LinkedList<>(Arrays.asList(numbers));
        LinkedList<String> urlsList = new LinkedList<>(Arrays.asList(urls));

        Smartphone smartphone = new Smartphone(numbersList, urlsList);

        for (String number : numbers) {
            try {
                System.out.println(smartphone.call());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String url : urls) {
            try {
                System.out.println(smartphone.browse());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
