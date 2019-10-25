package dependencyinversion;

public class Calculator {
    private Operation operation;

    public Calculator(){
        this.operation = new Addition();
    }

    public int calculate(int first, int second){
        return this.operation.execute(first, second);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
