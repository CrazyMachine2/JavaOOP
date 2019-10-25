package core.commands;

import contracts.Race;
import data.Database;
import exceptions.RaceAlreadyExistsException;
import models.race.RaceImpl;

public class OpenRace extends CommandImpl {
    public OpenRace(Database database, String[] data) {
        super(database, data);
    }

    @Override
    public String execute() {
        if(super.getDatabase().getRace() != null){
            throw new RaceAlreadyExistsException("The curent race has already been set.");
        }

        Race race = new RaceImpl(Integer.parseInt(super.getData()[1]),Integer.parseInt(super.getData()[2]),
                Integer.parseInt(super.getData()[3]),Boolean.valueOf("true"));

        super.getDatabase().setRace(race);

        String result =  String.format("A new race with distance %s meters, wind speed %s and ocean current speed %s has been set.",
                super.getData()[1],super.getData()[2],super.getData()[3]);
        return result;
    }
}
