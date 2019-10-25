package ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        Scanner scan = new Scanner(System.in);

        String driverName = scan.nextLine();
        Ferrari ferrari = new Ferrari(driverName);

        System.out.println(ferrari.toString());

    }
}
