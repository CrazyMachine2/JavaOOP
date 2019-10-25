package cresla.controllers;


import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private int idCount;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImpl(){
        this.idCount = 1;
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String type = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));

        Reactor reactor;
        if(type.equals("Cryo")){
            reactor = new CryoReactor(this.idCount,additionalParameter,moduleCapacity);
        } else {
            reactor = new HeatReactor(this.idCount,additionalParameter,moduleCapacity);
        }

        this.reactors.putIfAbsent(this.idCount,reactor);
        String message = String.format("Created %s Reactor – %d",type,this.idCount);
        this.idCount++;

        return message;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));

        Module generalModule;

        if(type.equals("CryogenRod")){
           EnergyModule energyModule = new CryogenRod(this.idCount,additionalParameter);
           generalModule = energyModule;
            this.reactors.get(reactorId).addEnergyModule(energyModule);
        } else {
            AbsorbingModule absorbingModule;
            if (type.equals("HeatProcessor")){
                absorbingModule = new HeatProcessor(this.idCount,additionalParameter);
            } else {
                absorbingModule = new CooldownSystem(this.idCount,additionalParameter);
            }
            generalModule = absorbingModule;
            this.reactors.get(reactorId).addAbsorbingModule(absorbingModule);
        }
        this.modules.putIfAbsent(this.idCount,generalModule);

        String message = String.format("Added %s - %d to Reactor - %d",type,this.idCount,reactorId);
        this.idCount++;

        return message;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));
        String message = "";

        if(this.reactors.containsKey(id)){
            message = this.reactors.get(id).toString();
        } else {
            message = this.modules.get(id).toString();
        }
        return message;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return this.toString();
    }

    @Override
    public String toString() {
     long cryoReactors = this.reactors.values().stream().filter(r -> r instanceof CryoReactor).count();
     long heatReactors = this.reactors.values().stream().filter(r -> r instanceof HeatReactor).count();
     long energyModules = this.modules.values().stream().filter(m -> m instanceof EnergyModule).count();
     long absorbingModules = this.modules.values().stream().filter(m -> m instanceof AbsorbingModule).count();
     long totalEnergyOutput = 0;
     long totalHeatAbsorbing = 0;


        totalEnergyOutput = this.reactors.values()
                 .stream()
                 .mapToLong(Reactor::getTotalEnergyOutput)
                 .sum();

        totalHeatAbsorbing = this.reactors.values()
                .stream()
                .mapToLong(Reactor::getTotalHeatAbsorbing)
                .sum();


        return String.format("Cryo Reactors: %d\n" +
                "Heat Reactors: %d\n" +
                "Energy Modules: %d\n" +
                "Absorbing Modules: %d\n" +
                "Total Energy Output: %d\n" +
                "Total Heat Absorbing: %d", cryoReactors,heatReactors,energyModules,
                absorbingModules,totalEnergyOutput,totalHeatAbsorbing);
    }
}
