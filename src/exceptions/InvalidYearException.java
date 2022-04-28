package exceptions;

public class InvalidYearException extends Exception {
    public InvalidYearException() {
        super("Invalid number of year.");
    }
}
