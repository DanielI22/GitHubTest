package exceptions;

public class InvalidCourseNameException extends Exception {
    public InvalidCourseNameException() {
        super("Course with the given name does not exist.");
    }
}
