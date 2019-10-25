package shoppingspree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Person> people = new LinkedHashMap<>();
        Map<String,Product> products = new HashMap<>();

        String[] nameAndMoney = reader.readLine().split(";");

        for (int i = 0; i < nameAndMoney.length; i++) {
            try {
                String[] data = nameAndMoney[i].split("=");
                Person person = new Person(data[0],Double.parseDouble(data[1]));
                people.putIfAbsent(data[0],person);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] nameAndPrice = reader.readLine().split(";");
        for (int i = 0; i < nameAndPrice.length; i++) {
            try {
                String[] data = nameAndPrice[i].split("=");
                Product product = new Product(data[0],Double.parseDouble(data[1]));
                products.putIfAbsent(data[0],product);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        while (true){
            String input = reader.readLine();

            if (input.equals("END")){
                break;
            }
            //TODO
            String name = input.substring(0,input.lastIndexOf(" "));
            String item = input.substring(input.lastIndexOf(" ") + 1);

            if(people.containsKey(name) && products.containsKey(item)){
                Person person = people.get(name);
                Product product = products.get(item);
                person.buyProduct(product);
            }
        }


        people.entrySet().forEach(entry -> {
            System.out.print(entry.getKey() + " - ");
            List<Product> productList = entry.getValue().getProducts();

            String joined = productList.stream().map(Product::getName)
                    .collect(Collectors.joining(", "));

            if (!productList.isEmpty()){
                System.out.print(joined);
                System.out.println();
            } else {
                System.out.print("Nothing bought");
                System.out.println();
            }

        });

    }
}
