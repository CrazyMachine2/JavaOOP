package bookshop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String author = scan.nextLine();
        String title = scan.nextLine();
        double price = Double.parseDouble(scan.nextLine());


        try {
            Book book = new Book(author,title,price);
            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author,title,price);

            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
