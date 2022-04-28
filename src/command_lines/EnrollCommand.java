package command_lines;

import bg.tu_varna.sit.*;
import exceptions.*;
import xml_parser_utils.ProgramNameToProgram;

public class EnrollCommand implements Command {
    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, InvalidProgramException, FileNotOpenedException, InvalidGroupException, StudentAlreadyExistsException {
        if(args.length < 4){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String fn = args[0].toString();
        String programName = args[1].toString();
        int group = Integer.parseInt(args[2].toString());
        String name = args[3].toString();


        Program program = ProgramNameToProgram.getProgram(programName);
        if(program==null) {
            throw new InvalidProgramException();
        }

        if(group < 0 || group > program.getNumberOfGroups()) {
            throw new InvalidGroupException();
        }

        Student student = new Student(name, fn);
        student.setGroup(group);
        student.setProgramName(program.getName());
        student.setYear(1);
        student.updateMandatoryCourses();
        student.updateAverageGrade();

        if(StudentServiceSystem.getInstance().getMainStudentSet().add(student)) {
            System.out.println(name + " successfully enrolled in year 1 of program " + program.getName() + " in group " + group + " with fn " + fn);
        }
        else {
            throw new StudentAlreadyExistsException();
        }
    }
}
