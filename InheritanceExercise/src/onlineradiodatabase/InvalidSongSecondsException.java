package onlineradiodatabase;

public class InvalidSongSecondsException extends InvalidSongLengthException {

    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
