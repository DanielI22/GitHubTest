package exceptions;

public class InvalidChangeOptionException extends Exception {
    public InvalidChangeOptionException() {
        super("Invalid option to change. Try again or type help");
    }
}
