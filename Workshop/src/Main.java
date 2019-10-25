import core.CommandInterpreterImpl;
import core.Engine;
import data.Database;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Engine engine = new Engine(new CommandInterpreterImpl(database));
        engine.run();
    }
}
