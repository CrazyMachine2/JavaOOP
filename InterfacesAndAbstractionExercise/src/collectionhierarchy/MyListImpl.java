package collectionhierarchy;

public class MyListImpl extends Collection implements MyList{
    @Override
    public int getUsed() {
        return this.getItems().size();
    }

    @Override
    public String remove() {
        if(!this.getItems().isEmpty()){
            return this.getItems().remove(0);
        }
        throw new IllegalArgumentException("The list is empty");
    }

    @Override
    public int add(String item) {
        this.getItems().add(item);
        return 0;
    }
}
