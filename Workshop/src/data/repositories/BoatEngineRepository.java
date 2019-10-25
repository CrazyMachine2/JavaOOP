package data.repositories;

import contracts.BoatEngine;
import contracts.Repository;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;

public class BoatEngineRepository implements Repository<BoatEngine> {
    private Map<String, BoatEngine> engines;

    public BoatEngineRepository(){
        this.engines = new HashMap<>();
    }

    @Override
    public BoatEngine getItem(String model) {
        if(!this.engines.containsKey(model)){
            throw new NonExistantModelException();
        }
        return this.engines.get(model);
    }

    @Override
    public void addItem(BoatEngine item) {
        if(this.engines.containsKey(item.getModel())){
            throw new DuplicateModelException();
        }
        this.engines.put(item.getModel(),item);
    }
}
