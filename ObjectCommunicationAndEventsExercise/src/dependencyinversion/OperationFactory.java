package dependencyinversion;

public class OperationFactory {

    public Operation produce(String operand) {
        Operation operation = null;

        switch (operand) {
            case "+":
                operation = new Addition();
                break;
            case "-":
                operation = new Subtraction();
                break;
            case "*":
                operation = new Multiplication();
                break;
            case "/":
                operation = new Division();
                break;
            case "f":
                operation = new Fibonacci();
                break;
            default:
                break;
        }
        return operation;
    }
}
