package stack;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        this.validate();
        String element = this.data.get(this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        return element;
    }

    public String peek(){
        this.validate();
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    private void validate(){
        if(this.isEmpty()){
            throw new InvalidDnDOperationException();
        }
    }
}
