package observers;


import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers;
    private String latestData;

    public Subject() {
        this.observers = new ArrayList<>();
        this.latestData = "";
    }

    public void register(Observer observer){
       this.observers.add(observer);
   }

   public void unregister(Observer observer){
        this.observers.remove(observer);
   }

   public void next(String data){
        this.latestData = data;
        this.notifyObservers();
   }

   private void notifyObservers(){
        this.observers.forEach(o -> o.update(this.latestData));
   }
}
