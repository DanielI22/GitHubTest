package exceptions;

public class AlreadyDoneException extends Exception {
    public AlreadyDoneException() {
        super("Student is already in the given program, group or year!");
    }
}
