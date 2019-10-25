package models;

public class ExpressSoftware extends Software {

    public ExpressSoftware(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * 2);
    }
}
