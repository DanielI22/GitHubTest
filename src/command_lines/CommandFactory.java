package command_lines;

public abstract class CommandFactory {
    public static Command getCommand(String commandName) {
        if (commandName.equalsIgnoreCase("open")) {
            return new OpenCommand();
        } else if (commandName.equalsIgnoreCase("close")) {
            return new CloseCommand();
        } else if (commandName.equalsIgnoreCase("save")) {
            return new SaveCommand();
        } else if (commandName.equalsIgnoreCase("saveas")) {
            return new SaveAsCommand();
        } else if (commandName.equalsIgnoreCase("exit")) {
            return new ExitCommand();
        } else if (commandName.equalsIgnoreCase("help")) {
            return new HelpCommand();
        } else if (commandName.equalsIgnoreCase("enroll")) {
            return new EnrollCommand();
        } else if (commandName.equalsIgnoreCase("advance")) {
            return new AdvanceCommand();
        } else if (commandName.equalsIgnoreCase("graduate")) {
            return new GraduateCommand();
        } else if (commandName.equalsIgnoreCase("change")) {
            return new ChangeCommand();
        } else if (commandName.equalsIgnoreCase("interrupt")) {
            return new InterruptCommand();
        } else if (commandName.equalsIgnoreCase("resume")) {
            return new ResumeCommand();
        } else if (commandName.equalsIgnoreCase("print")) {
            return new PrintCommand();
        } else if (commandName.equalsIgnoreCase("printall")) {
            return new PrintAllCommand();
        } else if (commandName.equalsIgnoreCase("enrollin")) {
            return new EnrollInCommand();
        } else {
            return null;
        }
    }
}
