package exceptions;

public class InvalidGraduationYearException extends Exception{
    public InvalidGraduationYearException() {
        super("Student cannot graduate this year!");
    }
}
