package exceptions;

public class InsufficientContestantsException extends RuntimeException {
    public InsufficientContestantsException(String message) {
        super(message);
    }
}
