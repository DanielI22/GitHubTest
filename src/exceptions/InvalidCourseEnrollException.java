package exceptions;

public class InvalidCourseEnrollException extends Exception{
    public InvalidCourseEnrollException() {
        super("Course does not exist in student's program year!");
    }
}
