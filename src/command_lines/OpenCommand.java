package command_lines;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.FileNotFoundException;
import exceptions.InvalidArgumentsExcepetion;
import xml_parser.JaxXMLToObject;

public class OpenCommand implements Command{
    public static boolean openedFile = false;
    public static String fileName;

    @Override
    public void execute(Object[] args) throws InvalidArgumentsExcepetion, FileNotFoundException {
        if(args.length==0){
            throw new InvalidArgumentsExcepetion();
        }
        fileName = args[0].toString();
        StudentServiceSystem.setSystemInstance(JaxXMLToObject.jaxbXmlFileToObject(fileName));
        openedFile=true;
        System.out.println(StudentServiceSystem.getInstance().toString());
        System.out.println("Successfully opened " + fileName);
    }
}
