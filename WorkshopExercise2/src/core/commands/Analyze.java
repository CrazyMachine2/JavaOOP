package core.commands;

import models.Hardware;

import java.util.Map;

public class Analyze extends CommandImpl {

    public Analyze(String[] data) {
        super(data);
    }

    @Override
    public void execute(Map<String, Hardware> hardwares) {
        System.out.println(String.format("System Analysis%n" +
                        "Hardware Components: %d%n" +
                        "Software Components: %d%n" +
                        "Total Operational Memory: %d / %d%n" +
                        "Total Capacity Taken: %d / %d",
                this.getCountOfHardwareComponents(hardwares),this.getCountOfSoftwareComponents(hardwares),
                this.getMemoryInUse(hardwares),this.getMaxMemory(hardwares),
                this.getTakenCapacity(hardwares),this.getMaxCapacity(hardwares)));
    }
    private int getMemoryInUse(Map<String, Hardware> hardwares){
        return hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getCurrentMemory()).sum();
    }

    private int getMaxMemory(Map<String, Hardware> hardwares){
        return hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getMaxMemory()).sum();
    }

    private int getTakenCapacity(Map<String, Hardware> hardwares){
        return hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getCurrentCapacity()).sum();
    }

    private int getMaxCapacity(Map<String, Hardware> hardwares){
        return hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getMaxCapacity()).sum();
    }

    private int getCountOfSoftwareComponents(Map<String, Hardware> hardwares){
        return hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getSoftwares().size()).sum();
    }

    private int getCountOfHardwareComponents(Map<String, Hardware> hardwares){
        return hardwares.size();
    }
}
