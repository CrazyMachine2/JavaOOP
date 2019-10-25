package commandpattern;

public interface Attacker {
    double getDmg();
    void setTarget(Target target);
    Target getTarget();
    void addXP(int xp);
}
