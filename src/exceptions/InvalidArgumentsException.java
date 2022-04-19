package exceptions;

public class InvalidArgumentsException extends Exception{
    public InvalidArgumentsException() {
        super("Invalid number of arguments. Try again or use help");
    }
}
