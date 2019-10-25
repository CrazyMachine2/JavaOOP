package stackofstrings;

import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings(List<String> data) {
        this.data = data;
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if(this.data.isEmpty()){
            throw new IllegalArgumentException("The stack is empty.");
        }
        return this.data.remove(this.data.size() - 1);
    }

    public String peek(){
        if(this.data.isEmpty()){
            throw new IllegalArgumentException("The stack is empty.");
        }
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
