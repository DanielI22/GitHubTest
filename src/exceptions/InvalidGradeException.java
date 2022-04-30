package exceptions;

public class InvalidGradeException extends Exception {
    public InvalidGradeException() {
        super("Invalid grade(2-6)!");
    }
}
