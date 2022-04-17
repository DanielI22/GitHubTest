package command_lines;

import exceptions.FileNotFoundException;
import exceptions.FileNotOpenedException;
import exceptions.InvalidArgumentsExcepetion;

public interface Command {
    void execute(Object[] args) throws FileNotOpenedException, InvalidArgumentsExcepetion, FileNotFoundException;
}
