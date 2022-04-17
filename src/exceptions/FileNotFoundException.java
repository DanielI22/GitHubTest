package exceptions;

public class FileNotFoundException extends Exception{
    public FileNotFoundException() {
        super("File path is not found. Try again");
    }
}
