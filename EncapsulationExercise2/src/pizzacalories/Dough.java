package pizzacalories;

import java.util.Arrays;
import java.util.List;

public class Dough {
    private static final List<String> FLOUR_TYPES = Arrays.asList("White","Wholegrain");
    private static final List<String> BAKING_TECHNIQUES = Arrays.asList("Crispy","Chewy","Homemade");
    private static final double DEFAULT_MODIFIER = 2.0;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }
    private void setFlourType(String flourType) {
        if(!FLOUR_TYPES.contains(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!BAKING_TECHNIQUES.contains(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double result = DEFAULT_MODIFIER * this.weight;

        switch (this.flourType){
            case "White":
                result *= 1.5;
                break;
            case "Wholegrain":
                result *= 1.0;
                break;
        }

        switch (this.bakingTechnique){
            case "Crispy":
                result *= 0.9;
                break;
            case "Chewy":
                result *= 1.1;
                break;
            case "Homemade":
                result *= 1.0;
                break;
        }
        return result;
    }

}
