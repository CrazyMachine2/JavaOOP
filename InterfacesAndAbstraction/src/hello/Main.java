package hello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Person bg = new Bulgarian("Pesho");
        Person eu = new European("ivan");
        Person che = new Chinese("gosho");

        people.add(bg);
        people.add(eu);
        people.add(che);

        people.forEach(Main::print);
    }

    private static void print(Person person){
        System.out.println(person.sayHello());
    }
}
