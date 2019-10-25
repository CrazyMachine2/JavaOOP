package wildfarm;

import wildfarm.animals.*;
import wildfarm.foods.Food;
import wildfarm.foods.Meat;
import wildfarm.foods.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Mammal> mammals = new ArrayList<>();

        while (true){
            String input = scan.nextLine();

            if(input.equals("End")){
                break;
            }

            String[] animalData = input.split(" ");
            String[] foodData = scan.nextLine().split(" ");

            String animalType = animalData[0];
            String animalName = animalData[1];
            Double animalWeight = Double.valueOf(animalData[2]);
            String livingRegion = animalData[3];
            String breed = "";

            Food food = createFood(foodData);

            if(animalData.length == 5){
                breed = animalData[4];
            }

            Mammal mammal = createMammal(animalName,animalType,animalWeight,livingRegion,breed);
            mammal.makeSound();
            feed(mammal,food);
            mammals.add(mammal);
        }

        for (Mammal mammal : mammals) {
            System.out.println(mammal.toString());
        }
    }

    private static Mammal createMammal(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        Mammal mammal = null;

        if(animalType.equals("Mouse")){
            mammal = new Mouse(animalName,animalType,animalWeight,livingRegion);
        } else if (animalType.equals("Zebra")){
            mammal = new Zebra(animalName,animalType,animalWeight,livingRegion);
        } else if (animalType.equals("Cat")){
            mammal = new Cat(animalName,animalType,animalWeight,livingRegion,breed);
        } else {
            mammal = new Tiger(animalName,animalType,animalWeight,livingRegion);
        }

        return mammal;
    }

    private static void feed(Mammal animal, Food food) {
        try {
            animal.eat(food);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static Food createFood(String[] vegetableData) {
        String foodType = vegetableData[0];
        Integer foodQuantity = Integer.valueOf(vegetableData[1]);

        Food food = null;

        if(foodType.equals("Vegetable")){
            food = new Vegetable(foodQuantity);
        } else {
            food = new Meat(foodQuantity);
        }

        return food;
    }
}
