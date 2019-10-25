package observers;

public abstract class Observer {
    public void update(String message){
        System.out.println(message);
    }
}
