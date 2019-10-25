package models;

public class HeavyHardware extends Hardware {

    public HeavyHardware(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type, maxCapacity, maxMemory);
    }

    @Override
    protected void setMaxCapacity(int maxCapacity) {
        super.setMaxCapacity(maxCapacity * 2);
    }

    @Override
    protected void setMaxMemory(int maxMemory) {
        super.setMaxMemory(maxMemory - ( maxMemory / 4 ));
    }


}
