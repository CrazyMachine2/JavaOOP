package observers;

import java.util.EventObject;

public class Event extends EventObject {
        private String changedName;

    /**
     * Constructs a prototypical observers.Event.
     *
     * @param source the object on which the observers.Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public Event(Object source, String changedName) {
        super(source);
        this.changedName = changedName;
    }

    public String getChangedName() {
        return this.changedName;
    }
}
