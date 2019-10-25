package dependencyinversion;

import jdk.dynalink.Operation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();
        OperationFactory factory = new OperationFactory();

        while (true){
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("End")){
                break;
            }

            String[] tokens = input.split("\\s+");

            if(tokens[0].equalsIgnoreCase("mode")){
                calculator.setOperation(factory.produce(tokens[1]));
            } else {
                System.out.println(calculator.calculate(
                        Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1])
                ));
            }
        }
    }
}
