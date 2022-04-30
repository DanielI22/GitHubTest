package exceptions;

public class InvalidCourseInMapException extends Exception {
    public InvalidCourseInMapException() {
        super("The given course does not exist in student's course list!");
    }
}
