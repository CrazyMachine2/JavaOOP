package models.engines;

public class SterndriveEngine extends BoatEngineImpl {
    public SterndriveEngine(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
    }

    @Override
    public int calculateOutput(int horsePower, int displacement) {
        return (horsePower * 7) + displacement;
    }
}
