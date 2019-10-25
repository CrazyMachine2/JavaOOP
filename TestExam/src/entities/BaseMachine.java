package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints){
        this.setName(name);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.setHealthPoints(healthPoints);
        this.targets = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if(pilot == null){
            throw new NullPointerException("Pilot cannot be null.");
        }
        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }


    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }

    //TODO: Check if target must be unique
    @Override
    public void attack(String target) {
        if(target == null || target.trim().isEmpty()){
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }
        this.targets.add(target);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DecimalFormat df = new DecimalFormat("#0.00");
        String targets = this.targets.isEmpty() ? "None" : String.join(", ",this.targets);

        sb.append("- ").append(this.getName()).append(System.lineSeparator());
        sb.append(" *Type: ").append(this.getClass().getInterfaces()[0].getSimpleName()).append(System.lineSeparator());
        sb.append(" *Health: ").append(df.format(this.getHealthPoints())).append(System.lineSeparator());
        sb.append(" *Attack: ").append(df.format(this.getAttackPoints())).append(System.lineSeparator());
        sb.append(" *Defense: ").append(df.format(this.getDefensePoints())).append(System.lineSeparator());
        sb.append(" *Targets: ").append(targets).append(System.lineSeparator());

        return sb.toString();
    }
}













