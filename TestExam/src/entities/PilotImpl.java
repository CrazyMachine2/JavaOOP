package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pilot name cannot be null or empty string.");
        }
        this.name = name;
    }

    //TODO: Check it target must be unique
    @Override
    public void addMachine(Machine machine) {
        if (machine == null) {
            throw new IllegalArgumentException("Null machine cannot be added to the pilot.");
        }
        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return Collections.unmodifiableList(this.machines);
    }

    //TODO: Implement this
    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();


        if (this.getMachines().isEmpty()) {
            sb.append(this.getName()).append(" - ").append(0).append(" machines");
        } else {
            sb.append(this.getName()).append(" - ").append(this.getMachines().size()).append(" machines").append(System.lineSeparator());

        }

        for (Machine machine : this.machines) {
            sb.append(machine.toString()).append(System.lineSeparator());
        }

        int index = sb.lastIndexOf("s");
        int length = sb.length() - 1;

        if(index != length){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
}
