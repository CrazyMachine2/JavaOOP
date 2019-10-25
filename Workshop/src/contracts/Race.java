package contracts;

import java.util.Map;

public interface Race {
    void addParticipant(Boat boat);
    Map<String,Boat> showParticipants();
    boolean hasEnoughContestants();
}
