package exceptions;

public class InvalidArgumentsExcepetion extends Exception{
    public InvalidArgumentsExcepetion() {
        super("Invalid number of arguments. Try again or use help");
    }
}
