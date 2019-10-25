package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;


    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }

    @Override
    public String hirePilot(String name) {

        //TODO: Might be a potential problem
        if(this.pilots.containsKey(name)){
            return String.format(OutputMessages.pilotExists,name);
        }

        Pilot pilot = this.pilotFactory.createPilot(name);
        this.pilots.putIfAbsent(name,pilot);

        return String.format(OutputMessages.pilotHired,name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if(this.machines.containsKey(name)){
            return String.format(OutputMessages.machineExists,name);
        }

        Machine tank = this.machineFactory.createTank(name,attackPoints,defensePoints);
        this.machines.putIfAbsent(name,tank);

        return String.format(OutputMessages.tankManufactured,name,attackPoints,defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if(this.machines.containsKey(name)){
            return String.format(OutputMessages.machineExists,name);
        }

        Machine fighter = this.machineFactory.createFighter(name,attackPoints,defensePoints);
        this.machines.putIfAbsent(name,fighter);

        return String.format(OutputMessages.fighterManufactured,name,attackPoints,defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if(!this.pilots.containsKey(selectedPilotName)){
            return String.format(OutputMessages.pilotNotFound,selectedPilotName);
        }

        if(!this.machines.containsKey(selectedMachineName)){
            return String.format(OutputMessages.machineNotFound,selectedMachineName);
        } else {
            if(this.machines.get(selectedMachineName).getPilot() != null){
                return String.format(OutputMessages.machineHasPilotAlready,selectedMachineName);
            }
        }


        Pilot currentPilot = this.pilots.get(selectedPilotName);
        Machine currentMachine = this.machines.get(selectedMachineName);

        currentPilot.addMachine(currentMachine);
        currentMachine.setPilot(currentPilot);

        return String.format(OutputMessages.machineEngaged,selectedPilotName,selectedMachineName);
    }

    //TODO: Check if refferences are correct
    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if(!this.machines.containsKey(attackingMachineName)){
            return String.format(OutputMessages.machineNotFound,attackingMachineName);
        }

        if(!this.machines.containsKey(defendingMachineName)){
            return String.format(OutputMessages.machineNotFound,defendingMachineName);
        }

        Machine attacker = this.machines.get(attackingMachineName);
        Machine defender = this.machines.get(defendingMachineName);

        if(attacker.getAttackPoints() > defender.getDefensePoints()){
            if(defender.getHealthPoints() - attacker.getAttackPoints() <= 0){
                defender.setHealthPoints(0);
            } else {
                defender.setHealthPoints(defender.getHealthPoints() - attacker.getAttackPoints());
            }
        }
        attacker.attack(defendingMachineName);

        return String.format(OutputMessages.attackSuccessful,
                defendingMachineName,attackingMachineName,defender.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if(!this.pilots.containsKey(pilotName)){
            return String.format(OutputMessages.pilotNotFound,pilotName);
        }

        return this.pilots.get(pilotName).report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if(!this.machines.containsKey(fighterName)){
            return String.format(OutputMessages.machineNotFound,fighterName);
        }
        Machine fighter = this.machines.get(fighterName);

        if(!(fighter instanceof Fighter)){
            return String.format(OutputMessages.notSupportedOperation,fighterName);
        }

        ((Fighter) fighter).toggleAggressiveMode();

        return String.format(OutputMessages.fighterOperationSuccessful,fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if(!this.machines.containsKey(tankName)){
            return String.format(OutputMessages.machineNotFound,tankName);
        }
        Machine tank = this.machines.get(tankName);

        if(!(tank instanceof Tank)){
            return String.format(OutputMessages.notSupportedOperation,tankName);
        }

       ((Tank) tank).toggleDefenseMode();

        return String.format(OutputMessages.tankOperationSuccessful,tankName);
    }
}
