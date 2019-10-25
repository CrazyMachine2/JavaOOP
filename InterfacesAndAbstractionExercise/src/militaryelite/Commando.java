package militaryelite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Commando extends SpecialisedSoldier {
    private Set<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public void addMission(Mission mission){
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator()).append("Missions:");
        this.missions.forEach(m -> sb.append(System.lineSeparator()).append(" ").append(m.toString()));

        return sb.toString();
    }
}
