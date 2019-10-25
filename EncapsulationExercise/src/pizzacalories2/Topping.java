package pizzacalories2;

import java.util.Arrays;
import java.util.List;

public class Topping {
    private static final double DEFAULT_MODIFIER = 2;
    private static final List<String> TOPPING_TYPES = Arrays.asList("Meat","Veggies","Cheese","Sauce");

    private String toppingType;
    private double toppingModifier;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setToppingModifier();
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!Topping.TOPPING_TYPES.contains(toppingType)){
            String message = String.format("Cannot place %s on top of your pizza.",toppingType);
            throw new IllegalArgumentException(message);
        }
        this.toppingType = toppingType;
    }

    private void setToppingModifier() {
        if(this.toppingType.equals("Meat")){
            this.toppingModifier = 1.2;
        } else if (this.toppingType.equals("Veggies")){
            this.toppingModifier = 0.8;
        } else if (this.toppingType.equals("Cheese")){
            this.toppingModifier = 1.1;
        } else if (this.toppingType.equals("Sauce")){
            this.toppingModifier = 0.9;
        }
    }

    private void setWeight(double weight) {
        if (weight < 1|| weight > 50){
            String message = String.format("%s weight should be in the range [1..50].",this.toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return (Topping.DEFAULT_MODIFIER * this.weight) * this.toppingModifier;
    }
}
