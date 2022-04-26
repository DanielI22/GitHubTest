package exceptions;

public class InvalidGraduationCoursesException extends Exception{
    public InvalidGraduationCoursesException() {
        super("Student has to pass all his mandatory courses to graduate!");
    }
}
