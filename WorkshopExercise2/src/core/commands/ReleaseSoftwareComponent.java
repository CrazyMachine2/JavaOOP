package core.commands;

import models.Hardware;

import java.util.Map;

public class ReleaseSoftwareComponent extends CommandImpl{
    public ReleaseSoftwareComponent(String[] data) {
        super(data);
    }

    @Override
    public void execute(Map<String, Hardware> hardwares) {
        String[] data = super.getData();

        if(hardwares.containsKey(data[1])){
            hardwares.get(data[1]).releaseSoftware(data[2]);
        }
    }
}
