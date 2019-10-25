package core.commands;

import contracts.Executable;
import data.Database;
import exceptions.InsufficientContestantsException;
import exceptions.NoSetRaceException;

public class StartRace extends CommandImpl {

    public StartRace(Database database, String[] data) {
        super(database, data);
    }

    @Override
    public String execute() {
        if(!super.getDatabase().getRace().hasEnoughContestants()){
         throw new InsufficientContestantsException("Not enough contestants for the race.");
        }

        if(super.getDatabase().getRace() == null){
            throw new NoSetRaceException("There is currently no race set.");
        }


        return null;
    }
}
