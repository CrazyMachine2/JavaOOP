package foodshortage;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Buyer> buyers = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");
            String name = data[0];

            if (buyers.containsKey(name)) {
                continue;
            }

            if (data.length == 4) {
              Citizen citizen = new Citizen(name,Integer.parseInt(data[1]),data[2],data[3]);
              buyers.put(name,citizen);

            } else {
                Rebel rebel = new Rebel(name, Integer.parseInt(data[1]), data[2]);
                buyers.put(name,rebel);
            }
        }

        int boughtAmmoundOfFood = 0;

        while (true) {
            String input = scan.nextLine();

            if (input.equals("End")) {
                break;
            }

            if (buyers.containsKey(input)) {
                buyers.get(input).buyFood();
            }
        }

        for (Buyer value : buyers.values()) {
            boughtAmmoundOfFood += value.getFood();
        }

        System.out.println(boughtAmmoundOfFood);
    }
}
