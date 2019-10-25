package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Beast!")) {
                break;
            }

            String[] data = scan.nextLine().split(" ");
            validateData(data);

            try {
                if (input.equals("Dog")) {
                    Dog dog = new Dog(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(dog);

                } else if (input.equals("Cat")) {
                    Cat cat = new Cat(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(cat);

                } else if (input.equals("Frog")) {
                    Frog frog = new Frog(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(frog);

                } else if (input.equals("Kitten")) {
                    Kitten kitten = new Kitten(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(kitten);

                } else if (input.equals("Tomcat")) {
                    Tomcat tomcat = new Tomcat(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(tomcat);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }

    }

    private static void validateData(String[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
}
