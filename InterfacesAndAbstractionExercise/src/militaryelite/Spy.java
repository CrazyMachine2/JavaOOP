package militaryelite;

public class Spy extends SoldierImpl {
    private String codeNumber;


    public Spy(int id, String firstName, String lastName,String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%nCode Number: %s",this.codeNumber);
    }
}
