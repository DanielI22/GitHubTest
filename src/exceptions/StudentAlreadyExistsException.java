package exceptions;

public class StudentAlreadyExistsException extends Exception{
    public StudentAlreadyExistsException() {
        super("Student with this faculty number already exists in the system!");
    }
}
