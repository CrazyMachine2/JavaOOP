package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100.0;
    private final double attackPointsModifier = 40.0;
    private final double deffencePointsModifier = 30.0;
    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.toggleDefenseMode();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if(!this.defenseMode){
            super.setAttackPoints(super.getAttackPoints() - this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() + this.deffencePointsModifier);
            this.defenseMode = true;
        } else {
            super.setAttackPoints(super.getAttackPoints() + this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() - this.deffencePointsModifier);
            this.defenseMode = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        String state = this.getDefenseMode() ? "ON" : "OFF";

        sb.append(" *Defense Mode").append("(").append(state).append(")");

        return sb.toString();
    }
}
