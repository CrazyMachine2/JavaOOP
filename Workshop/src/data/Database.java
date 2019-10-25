package data;

import contracts.Race;
import contracts.Repository;
import data.repositories.BoatEngineRepository;
import data.repositories.BoatRepository;


public class Database {
    private Repository  boatRepository;
    private Repository engineRepository;
    private Race race;

    public Database() {
        this.boatRepository = new BoatRepository();
        this.engineRepository = new BoatEngineRepository();
        this.race = null;
    }

    public Repository getBoatRepository() {
        return this.boatRepository;
    }

    public Repository getEngineRepository() {
        return this.engineRepository;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Race getRace(){
        return this.race;
    }
}
