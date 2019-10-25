package pizzacalories2;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name,int numberOfToppings){
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int toppings) {
        if (toppings < 0 || toppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppings);
    }

    public String getName() {
        return this.name;
    }

    public void addTopping (Topping topping){
        this.toppings.add(topping);
    }
    public double getOverallCalories(){
        double doughResult = this.dough.calculateCalories();
        double toppingsResult = 0;

        for (Topping topping : this.toppings){
            toppingsResult += topping.calculateCalories();
        }
        return doughResult + toppingsResult;
    }

}
