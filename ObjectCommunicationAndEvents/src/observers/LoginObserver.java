package observers;

public class LoginObserver extends Observer {

    @Override
    public void update(String message){
        System.out.print("Login: ");
        super.update(message);
    }
}
