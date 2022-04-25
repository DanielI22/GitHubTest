package command_lines;

import bg.tu_varna.sit.*;
import exceptions.*;

import java.util.*;

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
        Program program = null;

        for(Program current : StudentServiceSystem.getInstance().getMainProgramSet()) {
            if(current.getName().equalsIgnoreCase(programName)) {
                program = current;
            }
        }

        if(program == null) {
            throw new InvalidProgramException();
        }

        if(group < 0 || group > program.getNumberOfGroups()) {
            throw new InvalidGroupException();
        }

        Student student = new Student(name, fn);
        student.setGroup(group);
        student.setProgram(program.getName());
        student.setYear(1);

        for(Map.Entry<MandatoryCourse, String> current: program.getMandatoryCourseMap().entrySet()) {
            Scanner scanner = new Scanner(current.getValue());
            Set<Integer> yearsSet = new HashSet<>();
            while (scanner.hasNextInt()) {
                yearsSet.add(scanner.nextInt());
            }

            if(Collections.max(yearsSet) == 1) {
                student.getMandatoryCourseMap().put(current.getKey(),0);
            }
        }

            if(StudentServiceSystem.getInstance().getMainStudentSet().add(student)) {
                System.out.println(name + " successfully enrolled in year 1 of program " + program.getName() + " in group " + group + " with fn " + fn);
            }
            else {
                throw new StudentAlreadyExistsException();
            }
        }

}
