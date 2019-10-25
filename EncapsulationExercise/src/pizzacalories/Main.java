package pizzacalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            String[] pizzaData = scan.nextLine().split(" ");
            int numberOfToppings = Integer.parseInt(pizzaData[2]);
            Pizza pizza = new Pizza(pizzaData[1],numberOfToppings);
            String[] doughData = scan.nextLine().split(" ");
            Dough dough = new Dough(doughData[1],doughData[2],Double.parseDouble(doughData[3]));
            pizza.SetDough(dough);

            for (int i = 0; i < numberOfToppings; i++) {
                String[] toppingData = scan.nextLine().split(" ");
                Topping topping = new Topping(toppingData[1],Double.parseDouble(toppingData[2]));
                pizza.addTopping(topping);
            }

            System.out.println(pizza.toString());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

    }
}
