package exceptions;

public class InvalidStudentException extends Exception{
    public InvalidStudentException() {
        super("Student does not exist in the system!");
    }
}
