package core;

import contracts.Command;
import contracts.CommandParser;
import contracts.Runnable;
import models.Hardware;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller implements Runnable {
    private static final String END_COMMAND = "Split System";
    private Scanner scanner;
    private Map<String, Hardware> hardwares;
    private CommandParser commandParser;

    public Controller() {
        this.scanner = new Scanner(System.in);
        this.hardwares = new HashMap<>();
        this.commandParser = new CommandParserImpl();
    }

    @Override
    public void run() {

        while (true){
            String input = scanner.nextLine();
            Command command = this.commandParser.parseCommand(input);
            command.execute(this.hardwares);

            if(input.equals(END_COMMAND)){
                break;
            }
        }
    }
}
