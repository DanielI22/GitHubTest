package exceptions;

public class GradeAlreadyAddedException extends Exception {
    public GradeAlreadyAddedException() {
        super("The course has already added a grade!");
    }
}
