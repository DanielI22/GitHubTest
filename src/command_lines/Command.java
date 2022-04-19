package command_lines;

import exceptions.InvalidArgumentsException;
import exceptions.InvalidFileOrFilePathException;
import exceptions.FileNotOpenedException;

public interface Command {
    void execute(Object[] args) throws FileNotOpenedException, InvalidArgumentsException, InvalidFileOrFilePathException;
}
