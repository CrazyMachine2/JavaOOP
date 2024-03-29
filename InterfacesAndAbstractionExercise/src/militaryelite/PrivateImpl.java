package militaryelite;

public class PrivateImpl extends SoldierImpl {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName,double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "Salary: %.2f",this.salary);
    }
}
