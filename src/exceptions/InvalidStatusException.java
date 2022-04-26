package exceptions;

public class InvalidStatusException extends Exception{
    public InvalidStatusException() {
        super("Student's status is invalid!");
    }
}
