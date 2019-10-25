package core.commands;

import contracts.Factory;
import core.factories.SoftwareFactory;
import models.Hardware;
import models.Software;

import java.util.Map;

public class RegisterLightSoftware extends CommandImpl {
    private static final String TYPE_LIGHT = "Light";
    private Factory<Software> softwareFactory;

    public RegisterLightSoftware(String[] data) {
        super(data);
        this.softwareFactory = new SoftwareFactory();
    }
    @Override
    public void execute(Map<String, Hardware> hardwares) {
        String[] data = super.getData();

        if (hardwares.containsKey(data[1])) {
            Software software = this.softwareFactory.create
                    ( data[2],TYPE_LIGHT, Integer.parseInt(data[3]), Integer.parseInt(data[4]));

            hardwares.get(data[1]).registerSoftware(software);
        }
    }
}
