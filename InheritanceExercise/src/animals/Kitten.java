package animals;

public class Kitten extends Cat {

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return "Miau";
    }

    @Override
    protected void setGender(String gender){
        if(!gender.equals("Female")){
            throw new IllegalArgumentException("Invalid input!");
        }
        super.setGender(gender);
    }

}
