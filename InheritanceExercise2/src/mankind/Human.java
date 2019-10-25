package mankind;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        validateUpperCase(firstName,"firstName");

        if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    protected void setLastName(String lastName) {
        validateUpperCase(lastName,"lastName");

        if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }

        this.lastName = lastName;
    }

    private void validateUpperCase(String personName, String concreteName) {
        if(!Character.isUpperCase(personName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: " + concreteName);
        }
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%n" +
                "Last Name: %s%n",this.getFirstName(),this.getLastName());
    }
}
