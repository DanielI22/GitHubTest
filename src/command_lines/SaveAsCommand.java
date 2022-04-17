package command_lines;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.FileNotOpenedException;
import exceptions.InvalidArgumentsExcepetion;
import xml_parser.JaxObjectToXML;

public class SaveAsCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidArgumentsExcepetion {
        if(args.length==0){
            throw new InvalidArgumentsExcepetion();
        }
        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String fileName = args[0].toString();
        JaxObjectToXML.jaxbObjectToXML(StudentServiceSystem.getInstance(), fileName);

        System.out.println("Successfully saved " + fileName);
    }
}
