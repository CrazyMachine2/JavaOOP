package data.repositories;

import contracts.Boat;
import contracts.Repository;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;


public class BoatRepository implements Repository <Boat>{
    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new HashMap<>();
    }

    @Override
    public Boat getItem(String model) {
        if(!this.boats.containsKey(model)){
            throw new NonExistantModelException();
        }

        return this.boats.get(model);
    }

    @Override
    public void addItem(Boat item) {
        if(this.boats.containsKey(item.getModel())){
            throw new DuplicateModelException();
        }
        this.boats.put(item.getModel(),item);
    }
}
