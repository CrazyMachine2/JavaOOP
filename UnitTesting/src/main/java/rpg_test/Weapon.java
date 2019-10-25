package rpg_test;

public interface Weapon {
    void attack(Target target);
    public int getAttackPoints();
    int getDurabilityPoints();
}
