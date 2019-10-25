package models;

public class LightSoftware extends Software {

    public LightSoftware(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption + (capacityConsumption / 2));
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption / 2);
    }
}
