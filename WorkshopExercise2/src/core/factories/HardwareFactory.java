package core.factories;

import contracts.Factory;
import models.Hardware;
import models.HeavyHardware;
import models.PowerHardware;

public class HardwareFactory implements Factory<Hardware> {
    private static final String TYPE_POWER = "Power";

    @Override
    public Hardware create(String name, String type, int capacity, int memory) {
        Hardware hardware = null;

        if(type.equals(HardwareFactory.TYPE_POWER)){
            hardware = new PowerHardware(name,type,capacity,memory);
        } else {
            hardware = new HeavyHardware(name,type,capacity,memory);
        }

        return hardware;
    }
}
