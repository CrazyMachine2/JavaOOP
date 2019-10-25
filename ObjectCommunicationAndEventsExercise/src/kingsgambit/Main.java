package kingsgambit;

import kingsgambit.interfaces.Defender;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Defender> army = new LinkedHashMap<>();

        String kingName = scanner.nextLine();


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(name -> army.put(name,new RoyalGuard(name)));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(name -> army.put(name,new Footman(name)));

        King king = new King(kingName,army);

        while (true){
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("End")){
                break;
            }

            String[] data = command.split("\\s+");

            if(data[0].equalsIgnoreCase("Kill")){
                army.remove(data[1]);
            } else {
                king.onAttacked();
            }


        }
    }
}
