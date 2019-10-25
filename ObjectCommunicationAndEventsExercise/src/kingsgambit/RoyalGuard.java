package kingsgambit;

import kingsgambit.interfaces.Defender;

public class RoyalGuard extends Unit implements Defender {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public String respondToAttack() {
        return "Royal Guard" + this.getName() + " is defending!";
    }
}
