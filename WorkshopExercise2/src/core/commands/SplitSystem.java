package core.commands;

import models.ExpressSoftware;
import models.Hardware;
import models.LightSoftware;
import models.Software;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SplitSystem extends CommandImpl {
    public SplitSystem(String[] data) {
        super(data);
    }

    @Override
    public void execute(Map<String, Hardware> hardwares) {
        hardwares.entrySet().stream().sorted((f,s) -> s.getValue().getType().compareTo(f.getValue().getType()))
                .forEach(entry -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Hardware Component - ").append(entry.getKey())
                            .append(System.lineSeparator())
                            .append("Express Software Components - ").append(this.getCountOfExpressSoftwareComponents(hardwares,entry.getKey()))
                            .append(System.lineSeparator())
                            .append("Light Software Components - ").append(this.getCountOfLightSoftwareComponents(hardwares,entry.getKey()))
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

    private int getCountOfExpressSoftwareComponents(Map<String, Hardware> hardwares, String name){
        return hardwares.get(name).getSoftwares().entrySet().stream()
                .filter(entry -> entry.getValue() instanceof ExpressSoftware).collect(Collectors.toList()).size();
    }

    private int getCountOfLightSoftwareComponents(Map<String, Hardware> hardwares, String name){
        return hardwares.get(name).getSoftwares().entrySet().stream()
                .filter(entry -> entry.getValue() instanceof LightSoftware).collect(Collectors.toList()).size();
    }
}
