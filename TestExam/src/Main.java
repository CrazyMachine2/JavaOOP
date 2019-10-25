import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);


        while (true){
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("Over")){
                break;
            }

            String[] cmdArgs = input.split(" ");
            String message = "";

            String name = cmdArgs[1];

            switch (cmdArgs[0]){
                case "Hire":
                    message = machinesManager.hirePilot(name);
                    break;
                case "Report":
                    message = machinesManager.pilotReport(name);
                    break;
                case "ManufactureTank":
                    message = machinesManager.manufactureTank(
                            name,Double.parseDouble(cmdArgs[2]),Double.parseDouble(cmdArgs[3]));
                    break;
                case "ManufactureFighter":
                    message = machinesManager.manufactureFighter(
                            name,Double.parseDouble(cmdArgs[2]),Double.parseDouble(cmdArgs[3]));
                    break;
                case "Engage":
                    message = machinesManager.engageMachine(name,cmdArgs[2]);
                    break;
                case "Attack":
                    message = machinesManager.attackMachines(name,cmdArgs[2]);
                    break;
                case "DefenseMode":
                    message = machinesManager.toggleTankDefenseMode(name);
                    break;
                case "AggressiveMode":
                    message = machinesManager.toggleFighterAggressiveMode(name);
                    break;
            }

            System.out.println(message);
        }
    }
}
