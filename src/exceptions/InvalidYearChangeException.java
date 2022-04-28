package exceptions;

public class InvalidYearChangeException extends Exception {
    public InvalidYearChangeException() {
        super("Student cannot move to a year different from his next");
    }
}
