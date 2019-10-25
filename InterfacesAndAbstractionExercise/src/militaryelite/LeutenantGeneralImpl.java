package militaryelite;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LeutenantGeneralImpl extends PrivateImpl{
    private Set<PrivateImpl> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new HashSet<>();
    }

    public void add(PrivateImpl privateSoldier){
        this.privates.add(privateSoldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator()).append("Privates:");
        this.privates.stream()
                .sorted(Comparator.comparingInt(SoldierImpl::getId).reversed())
                .forEach(p -> sb.append(System.lineSeparator()).append(" ").append(p.toString()));

        return sb.toString();
    }
}




























