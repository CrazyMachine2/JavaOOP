package militaryelite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mission {
    private final String FINISHED_STATE = "Finished";
    private static final List<String> MISSION_STATES = new ArrayList<>(Arrays.asList("inProgress","Finished"));

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state){
        if (!Mission.MISSION_STATES.contains(state)){
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    public void completeMission(){
        this.state = FINISHED_STATE;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.codeName,this.state);
    }
}













