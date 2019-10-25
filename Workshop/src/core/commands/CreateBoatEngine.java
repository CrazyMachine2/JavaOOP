package core.commands;

import contracts.BoatEngine;
import contracts.Executable;
import contracts.Race;
import data.Database;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;

public class CreateBoatEngine extends CommandImpl {

    public CreateBoatEngine(Database database, String[] data) {
        super(database, data);
    }

    @Override
    public String execute() {
        BoatEngine engine = null;

        if(super.getData().equals("Jet")){
             engine = new JetEngine
                    (super.getData()[1],Integer.parseInt(super.getData()[2]),Integer.parseInt(super.getData()[3]));
        } else {
             engine = new SterndriveEngine
                    (super.getData()[1],Integer.parseInt(super.getData()[2]),Integer.parseInt(super.getData()[3]));
        }

        super.getDatabase().getEngineRepository().addItem(engine);

        String result = String.format("Engine model %s with %d HP and displacement %d cm3 created successfully.",
                super.getData()[1],Integer.parseInt(super.getData()[2]),Integer.parseInt(super.getData()[3]));

        return result;
    }
}
