package exceptions;

public class InvalidProgramException extends Exception{
    public InvalidProgramException() {
        super("Program does not exist in current student system program set!");
    }
}
