package command_lines;

public class CourseAlreadyEnrolledException extends Exception {
    public CourseAlreadyEnrolledException() {
        super("The given course is already enrolled.");
    }
}
