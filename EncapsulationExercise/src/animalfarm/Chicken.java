package animalfarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if((name.isEmpty() || (name.length() < 2 && name.charAt(0) == ' '))){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    private double calculateProductPerDay(){
        double result = 0.75;

        if(this.getAge() < 6){
            result = 2;
        } else if (this.getAge() > 5 && this.getAge() < 12){
            result = 1;
        }
        return result;
    }

    @Override
    public String toString() {
        String result = String.format("Chicken %s (age %d) can produce %.0f eggs per day."
                ,this.getName(),this.getAge(),this.productPerDay());

        if (this.getAge() > 11){
            result = String.format("Chicken %s (age %d) can produce %.2f eggs per day."
                    ,this.getName(),this.getAge(),this.productPerDay());
        }

        return result;
    }
}
