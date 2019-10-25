package commandpattern;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("asd",10);
        Target dragon = new Dragon(5,10,"asd");

        TargetCommand targetCommand = new TargetCommand(warrior,dragon);
        AttackCommand attackCommand = new AttackCommand(warrior);

        targetCommand.execute();
        attackCommand.execute();

        System.out.println(warrior.getXp());
    }
}
