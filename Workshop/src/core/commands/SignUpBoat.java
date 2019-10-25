package core.commands;

import contracts.Boat;
import contracts.Executable;
import data.Database;
import exceptions.NoSetRaceException;

public class SignUpBoat extends CommandImpl {

    public SignUpBoat(Database database, String[] data) {
        super(database, data);
    }

    @Override
    public String execute() {
        if(this.getDatabase().getRace() == null){
            throw new NoSetRaceException("There is currently no race set.");
        }

        String model = super.getData()[1];
        Boat boat = (Boat) super.getDatabase().getBoatRepository().getItem(model);
        this.getDatabase().getRace().addParticipant(boat);

        String result = String.format("Boat with model %s has signed up for the current Race.",model);

        return result;
    }
}
