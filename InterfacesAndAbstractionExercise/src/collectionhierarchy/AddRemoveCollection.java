package collectionhierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        if(!this.getItems().isEmpty()){
            return this.getItems().remove(this.getItems().size() - 1);
        }
       throw new IllegalArgumentException("The list is empty");
    }

    @Override
    public int add(String item) {
        this.getItems().add(item);
        return 0;
    }
}
