package observers;

public class EmailObserver extends Observer {

    @Override
    public void update(String message){
        System.out.print("Email: ");
        super.update(message);
    }
}
