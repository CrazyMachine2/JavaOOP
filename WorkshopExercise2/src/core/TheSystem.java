package core;

import contracts.Factory;
import core.factories.HardwareFactory;
import core.factories.SoftwareFactory;
import models.ExpressSoftware;
import models.Hardware;
import models.LightSoftware;
import models.Software;

import java.util.*;
import java.util.stream.Collectors;

public class TheSystem implements Runnable{
    private Map<String, Hardware> hardwares;
    private Factory<Hardware> hardwareFactory;
    private Factory<Software> softwareFactory;

    public TheSystem() {
        this.hardwares = new TreeMap<>();
        this.hardwareFactory = new HardwareFactory();
        this.softwareFactory = new SoftwareFactory();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(java.lang.System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("System Split")) {
                this.systemSplit();
                break;
            }

            if (input.equals("Analyze()")) {
                System.out.println(this.analyze());
                continue;
            }

            String fixedInput = input.replace("(", ", ").replace(")", "")
                    .replaceAll(" ", "");
            String[] data = fixedInput.split(",");

            if (data[0].contains("Register")) {
                if (data[0].contains("Hardware")) {

                    Hardware hardware = this.hardwareFactory.create
                            (data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));

                    this.hardwares.put(data[1], hardware);

                } else if (data[0].contains("Software")) {
                    if (this.hardwares.containsKey(data[1])) {
                        Software software = this.softwareFactory.create
                                (data[0], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));

                        this.hardwares.get(data[1]).registerSoftware(software);
                    }
                }
            } else if (data[0].contains("Release")){
                if(this.hardwares.containsKey(data[1])){
                    this.hardwares.get(data[1]).releaseSoftware(data[2]);
                }
            }
        }
    }

    private int getMemoryInUse(){
      return this.hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getCurrentMemory()).sum();

    }

    private int getMaxMemory(){
        return this.hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getMaxMemory()).sum();
    }

    private int getTakenCapacity(){
        return this.hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getCurrentCapacity()).sum();
    }

    private int getMaxCapacity(){
        return this.hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getMaxCapacity()).sum();
    }

    private int getCountOfSoftwareComponents(){
        return this.hardwares.entrySet().stream().mapToInt(entry -> entry.getValue().getSoftwares().size()).sum();
    }

    private int getCountOfHardwareComponents(){
        return this.hardwares.size();
    }

    private int getCountOfExpressSoftwareComponents(String name){
        return this.hardwares.get(name).getSoftwares().entrySet().stream()
                .filter(entry -> entry.getValue() instanceof ExpressSoftware).collect(Collectors.toList()).size();
    }

    private int getCountOfLightSoftwareComponents(String name){
       return this.hardwares.get(name).getSoftwares().entrySet().stream()
                .filter(entry -> entry.getValue() instanceof LightSoftware).collect(Collectors.toList()).size();
    }

    private String analyze(){
        return String.format("System Analysis%n" +
                        "Hardware Components: %d%n" +
                        "Software Components: %d%n" +
                        "Total Operational Memory: %d / %d%n" +
                        "Total Capacity Taken: %d / %d",
                this.getCountOfHardwareComponents(),this.getCountOfSoftwareComponents(),
                this.getMemoryInUse(),this.getMaxMemory(),
                this.getTakenCapacity(),this.getMaxCapacity());
    }

    private void systemSplit(){

        this.hardwares.entrySet().stream().sorted((f,s) -> s.getValue().getType().compareTo(f.getValue().getType()))
                .forEach(entry -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Hardware Component - ").append(entry.getKey())
                            .append(System.lineSeparator())
                            .append("Express Software Components - ").append(this.getCountOfExpressSoftwareComponents(entry.getKey()))
                            .append(System.lineSeparator())
                            .append("Light Software Components - ").append(this.getCountOfLightSoftwareComponents(entry.getKey()))
                            .append(System.lineSeparator())
                            .append("Memory Usage: ").append(entry.getValue().getCurrentMemory()).append(" / ").append(entry.getValue().getMaxMemory())
                            .append(System.lineSeparator())
                            .append("Capacity Usage: ").append(entry.getValue().getCurrentCapacity()).append(" / ").append(entry.getValue().getMaxCapacity())
                            .append(System.lineSeparator())
                            .append("Type: ").append(entry.getValue().getType())
                            .append(System.lineSeparator())
                            .append("Software Components: ");

                    if(entry.getValue().getSoftwares().isEmpty()){
                        sb.append("None");
                    } else {
                        List<Software> softwares =  new ArrayList<Software>(entry.getValue().getSoftwares().values());

                        String joinedSoftwares = softwares.stream().map(Software::getName)
                                .collect(Collectors.joining(", "));
                        sb.append(joinedSoftwares);
                    }
                    System.out.println(sb);
                    sb = new StringBuilder();
                });
        }
}
