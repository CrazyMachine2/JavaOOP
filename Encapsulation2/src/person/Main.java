package person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");
            try {
                Person person = new Person(data[0],data[1],Integer.parseInt(data[2]),Double.parseDouble(data[3]));
                people.add(person);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        double bonus = Double.parseDouble(scan.nextLine());

        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}
