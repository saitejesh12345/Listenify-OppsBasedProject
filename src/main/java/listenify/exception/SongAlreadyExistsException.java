package listenify.exception;

public class SongAlreadyExistsException extends  RuntimeException{
    public SongAlreadyExistsException(String message) {
        super(message);
    }
}
