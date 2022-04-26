package exceptions;

public class BadStudentException extends Exception{
    public BadStudentException() {
        super("Student cannot advance if 2 or more mandatory courses are not taken!");
    }
}
