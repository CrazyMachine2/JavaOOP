package fakes;

import rpg_test.Dummy;
import rpg_test.Target;
import rpg_test.Weapon;

public class FakeWeapon implements Weapon {
    private static final int BASE_ATTACK = 10;

    @Override
    public void attack(Target target) {
    }

    @Override
    public int getAttackPoints() {
        return BASE_ATTACK;
    }

    @Override
    public int getDurabilityPoints() {
        return 0;
    }
}
