package pizzacalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            String[] pizzaData = scan.nextLine().split(" ");
            Pizza pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));

            String[] doughData = scan.nextLine().split(" ");
            Dough dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));
            pizza.setDough(dough);

            int numberOfToppings = Integer.parseInt(pizzaData[2]);

            for (int i = 0; i < numberOfToppings; i++) {
                String[] toppingData = scan.nextLine().split(" ");
                Topping topping = new Topping(toppingData[1], Double.parseDouble(toppingData[2]));
                pizza.addTopping(topping);
            }

            System.out.print(pizza.toString());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
