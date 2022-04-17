package command_lines;

public class ExitCommand implements Command{
    @Override
    public void execute(Object[] args) {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
