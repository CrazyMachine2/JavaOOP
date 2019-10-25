package contracts;

public interface Factory <T> {
    T create(String name,String type, int capacity, int memory);

}
