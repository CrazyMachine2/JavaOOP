package exceptions;

public class RaceAlreadyExistsException extends RuntimeException{
    public RaceAlreadyExistsException(String message){
        super(message);
    }
}
