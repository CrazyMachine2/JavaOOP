package kingsgambit;

import kingsgambit.interfaces.Defender;

public class Footman extends Unit implements Defender {
    public Footman(String name) {
        super(name);
    }

    @Override
    public String respondToAttack() {
        return "Footman" + this.getName() + " is panicking!";
    }
}
