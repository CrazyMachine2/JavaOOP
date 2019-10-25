package collectionhierarchy;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String item) {
        if(this.getItems().isEmpty()){
            this.getItems().add(item);
            return 0;
        } else {
            this.getItems().add(this.getItems().size() -1,item);
        }

        return this.getItems().size() - 1;
    }
}
