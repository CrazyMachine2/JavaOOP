package pizzacalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppings) {
        setName(name);
        setToppings(toppings);
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setDough(Dough dough) {
        this.dough = dough;
    }

    public void SetDough(Dough dough){
        this.setDough(dough);
    }

    private void setToppings(int toppings) {
        if(toppings < 0 || toppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppings);
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        double result = this.dough.calculateCalories();

        for (Topping topping : this.toppings) {
            result += topping.calculateCalories();
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",this.name,this.getOverallCalories());
    }
}
