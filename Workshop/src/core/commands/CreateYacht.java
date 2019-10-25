package core.commands;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.Race;
import data.Database;
import models.boats.Yacht;

public class CreateYacht extends CommandImpl {
    public CreateYacht(Database database, String[] data) {
        super(database, data);
    }

    @Override
    public String execute() {
        BoatEngine first = (BoatEngine) super.getDatabase().getEngineRepository().getItem(super.getData()[3]);

        Boat boat = new Yacht
                (super.getData()[1],Integer.parseInt(super.getData()[2]),first,Integer.parseInt(super.getData()[4]));

        super.getDatabase().getBoatRepository().addItem(boat);

        String result = String.format("Yacht with model %s registered successfully.",super.getData()[1]);

        return result;
    }
}
