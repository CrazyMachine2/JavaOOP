package contracts;

public interface Repository <T>{
    T getItem(String model);
    void addItem(T item);
}
