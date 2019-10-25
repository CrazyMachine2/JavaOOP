package militaryelite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Engineer extends SpecialisedSoldier {
    private Set<Repairs> repairs;

    public Engineer(int id, String firstName, String lastName, double salary,String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new LinkedHashSet<>();
    }

    public void addRepairs(Repairs repairs){
        this.repairs.add(repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator()).append("Repairs:");
        this.repairs.forEach(r -> sb.append(System.lineSeparator()).append(" ").append(r.toString()));

        return sb.toString();
    }
}
























