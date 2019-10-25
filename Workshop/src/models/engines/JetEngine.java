package models.engines;

public class JetEngine extends BoatEngineImpl {

    public JetEngine(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
    }

    @Override
    public int calculateOutput(int horsePower, int displacement) {
        return (horsePower * 5) + displacement;
    }
}
