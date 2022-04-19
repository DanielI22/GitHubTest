package command_lines;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.FileNotOpenedException;
import exceptions.InvalidFileOrFilePathException;
import xml_parser.JaxObjectToXML;

public class SaveCommand implements Command{

    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidFileOrFilePathException {
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }
        JaxObjectToXML.jaxbObjectToXML(StudentServiceSystem.getInstance(), OpenCommand.filePath);

        System.out.println("Successfully saved " + OpenCommand.fileName);
    }
}
