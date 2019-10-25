package models;

public class PowerHardware extends Hardware {

    public PowerHardware(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type, maxCapacity, maxMemory);
    }

    @Override
    protected void setMaxCapacity(int maxCapacity) {
        super.setMaxCapacity(maxCapacity - ((maxCapacity * 3)/4));
    }

    @Override
    protected void setMaxMemory(int maxMemory) {

        super.setMaxMemory(maxMemory + ((maxMemory * 3)/4));
    }
}
