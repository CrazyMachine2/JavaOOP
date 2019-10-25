package onlineradiodatabase;

public class InvalidSongException extends RuntimeException {

    public InvalidSongException(){
    }

    public InvalidSongException(String message){
        super(message);
    }

    public InvalidSongException (Throwable cause) {
        super (cause);
    }

    public InvalidSongException (String message, Throwable cause) {
        super (message, cause);
    }
}
