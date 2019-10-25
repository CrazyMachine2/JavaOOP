package pizzacalories;

public class Topping {
    private static int DEFAULT_MODIFIER = 2;

    private String toppingType;
    private ToppingType toppingtype;
    private double weight;

    public Topping(String toppingtype, double weight) {
        this.setToppingtype(toppingtype);
        this.setWeight(weight);
    }

    private void setToppingtype(String toppingtype) {
        if (!isValidToppingType(toppingtype)){
            String message = String.format("Cannot place %s on top of your pizza.", toppingtype);
            throw new IllegalArgumentException(message);
        }
        this.toppingtype = ToppingType.valueOf(toppingtype);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            String message = String.format("%s weight should be in the range [1..50].",this.getToppingtype());
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public ToppingType getToppingtype() {
        return this.toppingtype;
    }

    public double getWeight() {
        return this.weight;
    }

    private boolean isValidToppingType(String toppingType){
        for (ToppingType type : ToppingType.values()){
            if(type.name().equals(toppingType)){
                return true;
            }
        }
        return false;
    }

    public double calculateCalories(){
        return Topping.DEFAULT_MODIFIER * this.getWeight() * this.getToppingtype().getValue();
    }
}
