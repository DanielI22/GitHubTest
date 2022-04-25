package exceptions;

public class InvalidGroupException extends Exception{
    public InvalidGroupException() {
        super("Invalid number of group.");
    }
}
