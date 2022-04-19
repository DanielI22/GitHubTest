package command_lines;

import exceptions.InvalidFileOrFilePathException;
import exceptions.FileNotOpenedException;
import exceptions.InvalidArgumentsException;

public interface Command {
    void execute(Object[] args) throws FileNotOpenedException, InvalidArgumentsException, InvalidFileOrFilePathException;
}
