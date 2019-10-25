package core.commands;

import contracts.Boat;
import contracts.Executable;
import contracts.Race;
import data.Database;
import models.boats.RowBoat;
import models.boats.SailBoat;

public class CreateSailBoat extends CommandImpl{


    public CreateSailBoat(Database database, String[] data) {
        super(database, data);
    }

    @Override
    public String execute() {
        Boat boat = new SailBoat
                (super.getData()[1],Integer.parseInt(super.getData()[2]),Integer.parseInt(super.getData()[3]));

        super.getDatabase().getBoatRepository().addItem(boat);

        String result = String.format("SailBoat with model %s registered successfully.",super.getData()[1]);

        return result;
    }
}
