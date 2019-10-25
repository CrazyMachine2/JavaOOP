package pizzacalories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {

        double doughCalories = this.dough.calculateCalories();
        double toppingsCalories = this.toppings.stream()
                .map(Topping::calculateCalories)
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(x -> x)
                .sum();

//        for (Topping topping : this.toppings){
//            toppingsCalories += topping.calculateCalories();
//        }

        return doughCalories + toppingsCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",this.name,this.getOverallCalories());
    }
}
