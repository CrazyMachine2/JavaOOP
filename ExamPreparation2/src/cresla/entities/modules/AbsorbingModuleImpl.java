package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorbingModuleImpl extends ModuleImpl implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbsorbingModuleImpl(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        return String.format("Absorbing Module – %d\n" +
                        "Heat Absorbing: %d",super.getId(),this.heatAbsorbing);
    }
}
