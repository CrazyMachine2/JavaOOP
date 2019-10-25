package mordorcrueltyplan;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {
    }

    public void eatFood(String food){
       this.foodPoints += this.getValueOfFood(food);
    }

    public int getFoodPoints(){
        return this.foodPoints;
    }

    public String getMood(){
        String mood = "JavaScript";

        if(this.foodPoints < -5){
            mood = "Angry";
        } else if(this.foodPoints < 0){
            mood = "Sad";
        } else if (this.foodPoints < 15){
            mood = "Happy";
        }
        return mood;
    }

    private int getValueOfFood(String food) {
        int result = -1;

        for(Foods f : Foods.values()){
            if(f.name().toLowerCase().equals(food.toLowerCase())){
                result = f.getValue();
            }
        }
        return result;
    }
}
