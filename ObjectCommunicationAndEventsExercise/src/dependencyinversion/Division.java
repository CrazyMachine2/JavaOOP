package dependencyinversion;

public class Division implements Operation{
    @Override
    public int execute(int first, int second) {
        return first / second;
    }
}
