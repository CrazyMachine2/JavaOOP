package pizzacalories2;

import java.util.Arrays;
import java.util.List;

public class Dough {
    private static final double DEFAULT_MODIFIER = 2;
    private static final List<String> FLOUR_TYPES = Arrays.asList("White","Wholegrain");
    private static final List<String> BAKING_TYPES = Arrays.asList("Crispy","Chewy","Homemade");

    private String flourType;
    private double flourModifier;
    private String bakingTechnique;
    private double bakingModifier;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setFlourModifier();
        this.setBakingTechnique(bakingTechnique);
        this.setBakingModifier();
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        this.isValidFlourTYpe(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        this.isValidBakingType(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourModifier() {
       if(this.flourType.equals("White")){
           this.flourModifier = 1.5;
       } else if (this.flourType.equals("Wholegrain")){
           this.flourModifier = 1.0;
       }
    }

    private void setBakingModifier() {
        if(this.bakingTechnique.equals("Crispy")){
            this.bakingModifier = 0.9;
        } else if (this.bakingTechnique.equals("Chewy")){
            this.bakingModifier = 1.1;
        } else if (this.bakingTechnique.equals("Homemade")){
            this.bakingModifier = 1.0;
        }
    }

    private void isValidFlourTYpe(String flourType) {
        if(!Dough.FLOUR_TYPES.contains(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void isValidBakingType(String bakingTechnique) {
        if(!Dough.BAKING_TYPES.contains(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories(){
        return (Dough.DEFAULT_MODIFIER * this.weight) * this.flourModifier * this.bakingModifier;
    }
}
