package wildfarm.animals;

import wildfarm.foods.Food;

public class Tiger extends Felime {


    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(!food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }
}
