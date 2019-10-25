import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
           try {
               Person person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
               people.add(person);
           } catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
           }
        }

        Team team = new Team("Minior");

        for (Person person : people) {
            team.addPlayer(person);
        }

        StringBuilder sb = new StringBuilder();

       sb.append("First team have ").append(team.getFirstTeam().size()).append(" players").append(System.lineSeparator());
       sb.append("Reserve team have ").append(team.getReserveTeam().size()).append(" players").append(System.lineSeparator());

        System.out.println(sb);
    }
}
