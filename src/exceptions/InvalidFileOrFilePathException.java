package exceptions;

public class InvalidFileOrFilePathException extends Exception{
    public InvalidFileOrFilePathException() {
        super("File format or file path is invalid. Try again");
    }
}
