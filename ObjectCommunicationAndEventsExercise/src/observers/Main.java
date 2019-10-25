package observers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener firstObserver = new EventHandlerPrinter();

        dispatcher.addObserver(firstObserver);

        while (true){
            String input = scanner.nextLine();

            if(input.equals("End")){
                break;
            }

            dispatcher.setName(input);
        }
    }
}
