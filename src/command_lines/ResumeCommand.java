package command_lines;

import bg.tu_varna.sit.Student;
import bg.tu_varna.sit.StudentStatus;
import exceptions.*;
import xml_parser_utils.FnToStudent;

public class ResumeCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidArgumentsException, InvalidStudentException, InvalidStatusException {
        if(args.length < 1){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String fn = args[0].toString();
        Student student = FnToStudent.findStudent(fn);

        if(!student.getStatus().equals(StudentStatus.INACTIVE)) {
            throw new InvalidStatusException();
        }

        student.setStatus(StudentStatus.ACTIVE);
        System.out.println("Student with fn " + fn + " rights are restored.");
    }
}
