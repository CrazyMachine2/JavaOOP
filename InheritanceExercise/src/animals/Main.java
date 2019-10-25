package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        while (true) {
            String animal = scan.nextLine();

            if (animal.equals("Beast!")) {
                break;
            }

            String[] data = scan.nextLine().split(" ");

            try {
                if (data.length < 3) {
                    throw new IllegalArgumentException("Invalid input!");
                }


                if (animal.equals("Cat")) {
                    Cat cat = new Cat(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(cat);
                } else if (animal.equals("Dog")) {
                    Dog dog = new Dog(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(dog);
                } else if (animal.equals("Frog")) {
                    Frog frog = new Frog(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(frog);
                } else if (animal.equals("Kitten")) {
                    Kitten kitten = new Kitten(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(kitten);
                } else if (animal.equals("Tomcat")) {
                    Tomcat tomcat = new Tomcat(data[0], Integer.parseInt(data[1]), data[2]);
                    animals.add(tomcat);
                } else {
                    throw new IllegalArgumentException("Invalid input!");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
