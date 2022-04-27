package exceptions;

public class UnallowedProgramChangeGradesException extends Exception {
    public UnallowedProgramChangeGradesException() {
        super("Student cannot change program if 1 or more mandatory courses of the new program from past years are not passed successfully");
    }
}
