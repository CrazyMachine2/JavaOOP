package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Hardware extends Component {
    private int maxCapacity;
    private int maxMemory;
    private Map<String, Software> softwares;
    private int currentCapacity;
    private int currentMemory;

    protected Hardware(String name, String type, int maxCapacity, int maxMemory) {
        super(name, type);
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        this.softwares = new LinkedHashMap<>();
        this.currentCapacity = 0;
        this.currentMemory = 0;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    protected void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxMemory() {
        return this.maxMemory;
    }

    protected void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

    public int getCurrentMemory() {
        return this.currentMemory;
    }

    public Map<String, Software> getSoftwares() {
        return Collections.unmodifiableMap(this.softwares);
    }

    public void registerSoftware (Software software){
        if (hasEnoughResources(software)) {
            this.softwares.put(software.getName(),software);

            this.currentCapacity += software.getCapacityConsumption();
            this.currentMemory += software.getMemoryConsumption();
        }
    }

    public void releaseSoftware (String name){
        if(this.softwares.containsKey(name)){
            Software softwareToRemove = this.softwares.get(name);
            this.currentCapacity -= softwareToRemove.getCapacityConsumption();
            this.currentMemory -= softwareToRemove.getMemoryConsumption();

            this.softwares.remove(name);
        }
    }

    private boolean hasEnoughResources(Software software) {
        return (software.getCapacityConsumption() + this.currentCapacity <= this.maxCapacity)
                && (software.getMemoryConsumption() + this.currentMemory <= this.maxMemory);
    }
}
