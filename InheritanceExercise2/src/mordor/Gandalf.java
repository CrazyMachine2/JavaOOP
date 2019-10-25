package mordor;

import java.util.Arrays;
import java.util.List;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {
    }

    public void eatFood(String food){
       for (Foods currentFood : Foods.values()){
           if(currentFood.toString().toLowerCase().equals(food.toLowerCase())){
               this.foodPoints += currentFood.getValue();
               return;
           }
       }
        this.foodPoints += -1;
    }

    public int getFoodPoints(){
        return this.foodPoints;
    }

    public String getMood(){
        String mood = "JavaScript";

        if(this.foodPoints < -5){
            mood = "Angry";
        } else if (this.foodPoints < 0){
            mood = "Sad";
        } else if (this.foodPoints < 15){
            mood = "Happy";
        }
        return mood;
    }
}













