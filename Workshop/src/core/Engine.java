package core;

import contracts.CommandInterpreter;
import contracts.Executable;

import java.util.Scanner;

public class Engine {
    private static final String END_COMMAND = "End";
    private final Scanner scanner;
    private final CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter){
       this.scanner = new Scanner(System.in);
       this.commandInterpreter = commandInterpreter;
    }

    public void run(){
       while (true){
           String input = scanner.nextLine();

           if(input.equals(END_COMMAND)){
               break;
           }

           try {
               Executable executable =  this.commandInterpreter.interpretCommand(input.split("\\\\"));
               String result = executable.execute();
               System.out.println(result);
           } catch (Exception e){
               System.out.println(e.getMessage());
           }

       }
    }
}
