package core.commands;

import contracts.Boat;
import contracts.Race;
import data.Database;
import models.boats.RowBoat;

public class CreateRowBoat extends CommandImpl {

    public CreateRowBoat(Database database, String[] data) {
        super(database,data);
    }

    @Override
    public String execute() {
        Boat boat = new RowBoat
                (super.getData()[1],Integer.parseInt(super.getData()[2]),Integer.parseInt(super.getData()[3]));

        super.getDatabase().getBoatRepository().addItem(boat);

        String result = String.format("RowBoat with model %s registered successfully.",super.getData()[1]);
        return result;
    }
}
