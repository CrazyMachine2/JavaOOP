package core.commands;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.Executable;
import contracts.Race;
import data.Database;
import models.boats.PowerBoat;
import models.boats.RowBoat;

public class CreatePowerBoat extends CommandImpl {

    public CreatePowerBoat(Database database, String[] data) {
        super(database, data);
    }

    @Override
    public String execute() {
        BoatEngine first = (BoatEngine) super.getDatabase().getEngineRepository().getItem(super.getData()[3]);
        BoatEngine second = (BoatEngine) super.getDatabase().getEngineRepository().getItem(super.getData()[4]);

        Boat boat = new PowerBoat
                (super.getData()[1],Integer.parseInt(super.getData()[2]),first,second);

        super.getDatabase().getBoatRepository().addItem(boat);

        String result = String.format("PowerBoat with model %s registered successfully.",super.getData()[1]);
        return result;
    }
}
