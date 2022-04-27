package exceptions;

public class UnallowedProgramChangeException extends Exception {
    public UnallowedProgramChangeException() {
        super("Changing to the given program is not allowed due to non-compliance of the mandatory courses. Check curriculum");
    }
}
