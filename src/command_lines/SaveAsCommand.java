package command_lines;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.FileNotOpenedException;
import exceptions.InvalidArgumentsException;
import exceptions.InvalidFileOrFilePathException;
import xml_parser_utils.JaxObjectToXML;

public class SaveAsCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidFileOrFilePathException, InvalidArgumentsException {
        if(args.length==0){
            throw new InvalidArgumentsException();
        }
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String filePath = args[0].toString();
        JaxObjectToXML.jaxbObjectToXML(StudentServiceSystem.getInstance(), filePath);
        String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
        System.out.println("Successfully saved " + fileName);
    }
}
