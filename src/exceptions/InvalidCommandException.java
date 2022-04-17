package exceptions;

public class InvalidCommandException extends Exception{
    public InvalidCommandException() {
        super("Invalid command. Try again or use help");
    }
}
