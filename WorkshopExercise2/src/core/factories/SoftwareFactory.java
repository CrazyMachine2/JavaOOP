package core.factories;

import contracts.Factory;
import models.ExpressSoftware;
import models.LightSoftware;
import models.Software;

public class SoftwareFactory implements Factory<Software> {
    private static final String TYPE_EXPRESS = "Express";

    @Override
    public Software create(String name, String type, int capacity, int memory) {
        Software software = null;

        if(type.equals(TYPE_EXPRESS)){
            software = new ExpressSoftware(name,type,capacity,memory);
        } else {
            software = new LightSoftware(name,type,capacity,memory);
        }

        return software;
    }
}
