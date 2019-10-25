package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;
import hell.interfaces.Manager;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new ManagerImpl();

        while (true){
            String cmd = scanner.nextLine();

            if(cmd.equalsIgnoreCase("Quit")){
                String result = manager.quit();
                System.out.println(result);
                break;
            }

            String[] commandArgs = cmd.split(" ");
            String commandName = commandArgs[0];

            String result = "";

            switch (commandName){
                case "Hero":
                    result = manager.addHero(
                            Arrays.asList(commandArgs[1],commandArgs[2]));
                    break;
                case "Item":
                    result = manager.addItem(Arrays.asList(commandArgs));
                    break;
                case "Recipe":
                    result = manager.addRecipe(Arrays.asList(commandArgs));
                    break;
                case "Inspect":
                    result = manager.inspect(Arrays.asList(commandArgs));
            }
            System.out.println(result);
        }
    }
}