package models;

public abstract class Software extends Component{
    private int capacityConsumption;
    private int memoryConsumption;

    protected Software(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);

    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    public int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    public int getMemoryConsumption() {
        return this.memoryConsumption;
    }
}
