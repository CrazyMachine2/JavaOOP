package models.race;

import contracts.Boat;
import contracts.Race;
import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.boats.MotorBoat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Map<String, Boat> participants;
    private boolean allowMotorBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed,boolean allowMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.participants = new HashMap<>();
        this.allowMotorBoats = allowMotorBoats;
    }

    private void setDistance(int distance) {
        if(distance < 1){
            throw new IllegalArgumentException("Distance must be a positive integer.");
        }
        this.distance = distance;
    }

    @Override
    public void addParticipant(Boat boat) {
        if(!this.allowMotorBoats && boat instanceof MotorBoat){
            throw new ArgumentException("The specified boat does not meet the race constraints.");
        }

        if(this.participants.containsKey(boat.getModel())){
            throw new DuplicateModelException();
        }
        this.participants.put(boat.getModel(),boat);
    }


    @Override
    public Map<String, Boat> showParticipants() {
        return Collections.unmodifiableMap(this.participants);
    }

    @Override
    public boolean hasEnoughContestants() {
        return this.participants.size() >= 3 ;
    }
}
