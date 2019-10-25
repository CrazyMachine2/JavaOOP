package observers;

public class EventHandlerSender implements NameChangeListener {
    @Override
    public void handleOnNameChanged(Event event) {
        System.out.println(String.format("Sending on the web... %s",event.getChangedName()));
    }
}
