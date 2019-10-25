package randomarraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private Random random;

    public RandomArrayList(){
        super();
        this.random = new Random();
    }

    public T getRandomElement(){
        int index = this.random.nextInt(this.size());

        T element = this.get(index);
        this.remove(element);
        return element;
    }


}
