package custom_exceptions;

public class DropDeadlinePassedException extends Exception {
    public DropDeadlinePassedException(String message) {
        super(message);
    }
}
