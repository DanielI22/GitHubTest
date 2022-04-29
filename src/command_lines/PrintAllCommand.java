package command_lines;

import bg.tu_varna.sit.Program;
import bg.tu_varna.sit.Student;
import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.*;
import xml_parser_utils.ProgramNameToProgram;

public class PrintAllCommand implements Command {

    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, FileNotOpenedException, InvalidProgramException, InvalidYearException {
        if(args.length < 2){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String programName = args[0].toString();
        int year = Integer.parseInt(args[1].toString());

        Program program = ProgramNameToProgram.getProgram(programName);
        if(program==null) {
            throw new InvalidProgramException();
        }

        if(year <= 0 || year > program.getNumberOfYears()) {
            throw new InvalidYearException();
        }

        boolean isEmpty = true;
        for(Student current: StudentServiceSystem.getInstance().getMainStudentSet()) {
            if(current.getProgramName().equalsIgnoreCase(programName) && current.getYear() == year) {
                isEmpty = false;
                System.out.println(current + "\n");
            }
        }
        if(isEmpty) {
            System.out.println("None students found!");
        }
    }
}
