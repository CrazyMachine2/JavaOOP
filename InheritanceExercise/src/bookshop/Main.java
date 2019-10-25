package bookshop;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        try {

            String author = scanner.nextLine();
            String title = scanner.nextLine();
            double price = Double.valueOf(scanner.nextLine());

            Book book = new Book(author,
                    title,
                    price);

            GoldenEditionBook goldenEditionBook =
                    new GoldenEditionBook(author,
                            title,
                            price);


            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
