package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200.0;
    private final double attackPointsModifier = 50.0;
    private final double deffencePointsModifier = 25.0;
    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if(!this.aggressiveMode){
            super.setAttackPoints(super.getAttackPoints() + this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() - this.deffencePointsModifier);
            this.aggressiveMode = true;
        } else {
            super.setAttackPoints(super.getAttackPoints() - this.attackPointsModifier);
            super.setDefensePoints(super.getDefensePoints() + this.deffencePointsModifier);
            this.aggressiveMode = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        String state = this.getAggressiveMode() ? "ON" : "OFF";

        sb.append(" *Aggressive Mode").append("(").append(state).append(")");

        return sb.toString();
    }
}
