package core;

import contracts.CommandInterpreter;
import contracts.Executable;
import core.commands.*;
import data.Database;

public class CommandInterpreterImpl implements CommandInterpreter {
    private Database database;

    public CommandInterpreterImpl(Database database) {
        this.database = database;
    }

    @Override
    public Executable interpretCommand(String[] data) {
        Executable executable = null;

        switch (data[0]){
            case "CreateBoatEngine":
                executable = new CreateBoatEngine(this.database,data);
                break;
            case "CreateRowBoat":
                executable = new CreateRowBoat(this.database,data);
                break;
            case "CreateSailBoat":
                executable = new CreateSailBoat(this.database,data);
                break;
            case "CreatePowerBoat":
                executable = new CreatePowerBoat(this.database,data);
                break;
            case "CreateYacht":
                executable = new CreateYacht(this.database,data);
                break;
            case "OpenRace":
                executable = new OpenRace(this.database,data);
                break;
            case "SignUpBoat":
                executable = new SignUpBoat(this.database,data);
                break;
            case "StartRace":
                executable = new StartRace(this.database,data);
                break;
        }
        return executable;
    }

}
