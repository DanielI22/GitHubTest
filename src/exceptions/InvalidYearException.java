package exceptions;

public class InvalidYearException extends Exception {
    public InvalidYearException() {
        super("Student cannot move to a year different from his next");
    }
}
