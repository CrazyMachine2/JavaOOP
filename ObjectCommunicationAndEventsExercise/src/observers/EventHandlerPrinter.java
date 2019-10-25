package observers;

public class EventHandlerPrinter implements NameChangeListener {

    @Override
    public void handleOnNameChanged(Event event) {
        System.out.println(String.format("observers.Dispatcher's name changed to %s.", event.getChangedName()));
    }
}
