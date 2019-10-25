package core.commands;

import contracts.Factory;
import core.factories.HardwareFactory;
import models.Hardware;

import java.util.Map;

public class RegisterPowerHardware extends CommandImpl {
    private static final String TYPE_POWER = "Power";
    private Factory<Hardware> hardwareFactory;

    public RegisterPowerHardware(String[] data) {
        super(data);
        this.hardwareFactory = new HardwareFactory();
    }

    @Override
    public void execute(Map<String, Hardware> hardwares) {
        String[] data = super.getData();

        Hardware hardware = this.hardwareFactory.create
                (data[1],TYPE_POWER, Integer.parseInt(data[2]), Integer.parseInt(data[3]));

        hardwares.put(data[1], hardware);
    }
}
