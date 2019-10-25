package shoppingspree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] peopleData = scan.nextLine().split(";");
        String[] productData = scan.nextLine().split(";");

        for (String peopleDatum : peopleData) {
            String[] data = peopleDatum.split("=");
            try {
                Person person = new Person(data[0], Double.parseDouble(data[1]));
                people.put(data[0], person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String productDatum : productData) {
            String[] data = productDatum.split("=");
            try {
                Product product = new Product(data[0], Double.parseDouble(data[1]));
                products.put(data[0], product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            String input = scan.nextLine();
            if (input.equals("END")) {
                break;
            }

            String[] data = input.split(" ");
            Person person = people.get(data[0]);
            Product product = products.get(data[1]);

            person.buyProduct(product);
        }

        people.entrySet().forEach(entry ->{
            List<Product> shoppingList = entry.getValue().getProducts();

            System.out.printf("%s - ",entry.getKey());

            String joined = shoppingList.stream().map(Product::getName)
                    .collect(Collectors.joining(", "));

            if (!shoppingList.isEmpty()){
                System.out.print(joined);
                System.out.println();
            } else {
                System.out.print("Nothing bought");
                System.out.println();
            }
        });

    }
}
