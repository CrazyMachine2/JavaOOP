package cresla.controllers;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Manager manager;

    public Engine() {
        this.inputReader = new InputReaderImpl();
        this.outputWriter = new OutputWriterImpl();
        this.manager = new ManagerImpl();
    }


    public void run() {
        while (true) {
            String input = this.inputReader.readLine();
            if (input.equalsIgnoreCase("Exit")) {
                this.outputWriter.write(this.manager.exitCommand(Arrays.asList(input.split(" "))));
                break;
            }

            String cmd = input.split(" ")[0];
            List<String> cmdArgs = Arrays.stream(input.split(" ")).skip(1).collect(Collectors.toList());

            String message = "";

            switch (cmd) {
                case "Reactor":
                    message = this.manager.reactorCommand(cmdArgs);
                    break;
                case "Module":
                    message = this.manager.moduleCommand(cmdArgs);
                    break;
                case "Report":
                    message = this.manager.reportCommand(cmdArgs);
                    break;
            }

            this.outputWriter.write(message);
        }

    }
}
