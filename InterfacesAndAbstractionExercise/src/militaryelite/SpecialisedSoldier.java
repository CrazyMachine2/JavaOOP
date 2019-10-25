package militaryelite;

public class SpecialisedSoldier extends PrivateImpl {
    private Corps corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary,String corps) {
        super(id, firstName, lastName, salary);
        this.corps = new Corps(corps);
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%nCorps: %s",this.corps.getCorpName());
    }
}
