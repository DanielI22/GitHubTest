package command_lines;

import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.InvalidArgumentsException;
import exceptions.InvalidFileOrFilePathException;
import xml_parser.JaxXMLToObject;

public class OpenCommand implements Command{
    public static boolean openedFile = false;
    public static String filePath;
    public static String fileName;

    @Override
    public void execute(Object[] args) throws InvalidFileOrFilePathException, InvalidArgumentsException {
        if(args.length==0){
            throw new InvalidArgumentsException();
        }
        filePath = args[0].toString();
        StudentServiceSystem.setSystemInstance(JaxXMLToObject.jaxbXmlFileToObject(filePath));
        openedFile=true;

        System.out.println(StudentServiceSystem.getInstance().toString());
        fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
        System.out.println("Successfully opened " + fileName);
    }
}
