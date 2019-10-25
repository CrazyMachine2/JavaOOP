package core;

import contracts.Command;
import contracts.CommandParser;
import core.commands.*;

public class CommandParserImpl implements CommandParser {
    @Override
    public Command parseCommand(String input) {
        Command currentCommand = null;
        String commandName = "";

        commandName = input;
        if(input.lastIndexOf("(") != -1){
           commandName =  input.substring(0,input.indexOf("("));
        }

        String[] data = input.replace("(", ", ").replace(")", "")
                .replaceAll(" ", "").split(",");

        switch (commandName){
            case "RegisterPowerHardware":
                currentCommand = new RegisterPowerHardware(data);
                break;
            case "RegisterHeavyHardware":
                currentCommand = new RegisterHeavyHardware(data);
                break;
            case "RegisterExpressSoftware":
                currentCommand = new RegisterExpressSoftware(data);
                break;
            case "RegisterLightSoftware":
                currentCommand = new RegisterLightSoftware(data);
                break;
            case "ReleaseSoftwareComponent":
                currentCommand = new ReleaseSoftwareComponent(data);
                break;
            case "Analyze":
                currentCommand = new Analyze(data);
                break;
            case "System Split":
                currentCommand = new SplitSystem(data);
                break;
        }

        return currentCommand;
    }
}
