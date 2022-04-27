package command_lines;


import bg.tu_varna.sit.Student;
import bg.tu_varna.sit.StudentStatus;
import exceptions.FileNotOpenedException;
import exceptions.InvalidArgumentsException;
import exceptions.InvalidStatusException;
import exceptions.InvalidStudentException;
import xml_parser_utils.FnToStudent;

public class InterruptCommand implements Command {
    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, FileNotOpenedException, InvalidStudentException, InvalidStatusException {
        if(args.length < 1){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String fn = args[0].toString();
        Student student = FnToStudent.findStudent(fn);

        if(!student.getStatus().equals(StudentStatus.ACTIVE)) {
            throw new InvalidStatusException();
        }

        student.setStatus(StudentStatus.INACTIVE);
        System.out.println("Student with fn " + fn + " is no longer active student.");
    }
}
