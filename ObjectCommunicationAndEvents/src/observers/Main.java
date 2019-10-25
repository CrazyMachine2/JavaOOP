package observers;

public class Main {
    public static void main(String[] args) {
        EmailObserver emailObserver = new EmailObserver();
        LoginObserver loginObserver = new LoginObserver();


        Subject subject = new Subject();
        subject.register(emailObserver);
        subject.next("NEW DATA");

        subject.register(loginObserver);
        subject.next("NEW DATA FOR BOTH");
    }
}
