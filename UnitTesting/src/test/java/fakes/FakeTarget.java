package fakes;

import rpg_test.Target;
import rpg_test.Weapon;

public class FakeTarget implements Target {
    private static final int BASE_XP = 10;
    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void takeAttack(int attackPoints) {

    }

    @Override
    public int giveExperience() {
        return BASE_XP;
    }

    @Override
    public boolean isDead() {
        return true;
    }

    @Override
    public Weapon getLoot() {
        return null;
    }
}
