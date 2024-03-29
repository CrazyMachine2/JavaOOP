package animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound(){
        return "Give me one million b***h";
    }

    @Override
    protected void setGender(String gender){
        if(!gender.equals("Male")){
            throw new IllegalArgumentException("Invalid input!");
        }
        super.setGender(gender);
    }
}
