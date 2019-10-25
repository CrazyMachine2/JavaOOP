package pizzacalories;

import java.util.Arrays;
import java.util.List;

public class Topping {
    private static final List<String> TOPPING_NAMES = Arrays.asList("Meat","Veggies","Cheese","Sauce");
    private static final double DEFAULT_MODIFIER = 2.0;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType){
       if(!TOPPING_NAMES.contains(toppingType)){
           throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
       }
        this.toppingType = toppingType;
    }


    private void setWeight(double weight){
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",
                    this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double result = DEFAULT_MODIFIER * this.weight;
        switch (this.toppingType){
            case "Meat":
                result *= 1.2;
                break;
            case "Veggies":
                result *= 0.8;
                break;
            case "Cheese":
                result *= 1.1;
                break;
            case "Sauce":
                result *= 0.9;
                break;
        }
        return result;
    }
}
