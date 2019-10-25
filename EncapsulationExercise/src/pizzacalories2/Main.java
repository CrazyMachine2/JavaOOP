package pizzacalories2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {

            String[] pizzaData = scan.nextLine().split(" ");

            String pizzaName = pizzaData[1];
            int numberOfToppings = Integer.parseInt(pizzaData[2]);

            Pizza pizza = new Pizza(pizzaName,numberOfToppings);

            String[] doughData = scan.nextLine().split(" ");

            String flourType = doughData[1];
            String bakingTechnique = doughData[2];
            double doughWeight = Double.parseDouble(doughData[3]);

            Dough dough = new Dough(flourType,bakingTechnique,doughWeight);
            pizza.setDough(dough);

            for (int i = 0; i < numberOfToppings; i++) {
                String[] toppingData = scan.nextLine().split(" ");

                String toppingType = toppingData[1];
                double toppingWeight = Double.parseDouble(toppingData[2]);

                Topping topping = new Topping(toppingType,toppingWeight);
                pizza.addTopping(topping);
            }

            double overallCalories = pizza.getOverallCalories();
            System.out.printf("%s - %.2f%n",pizzaName,overallCalories);

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
