package exceptions;

public class BadStudentException extends Exception{
    public BadStudentException() {
        super("Student cannot advance if 3 or more mandatory courses are not passed successfully!");
    }
}
