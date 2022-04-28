package command_lines;

import bg.tu_varna.sit.Student;
import exceptions.*;
import xml_parser_utils.FnToStudent;

public class PrintCommand implements Command {

    @Override
    public void execute(Object[] args) throws InvalidStudentException, FileNotOpenedException, InvalidArgumentsException {
        if(args.length < 1){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String fn = args[0].toString();
        Student student = FnToStudent.findStudent(fn);

        System.out.println(student);
    }
}
