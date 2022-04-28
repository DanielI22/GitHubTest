package command_lines;

import bg.tu_varna.sit.MandatoryCourse;
import bg.tu_varna.sit.Program;
import bg.tu_varna.sit.Student;
import bg.tu_varna.sit.StudentStatus;
import exceptions.*;
import xml_parser_utils.FnToStudent;
import xml_parser_utils.ProgramNameToProgram;
import xml_parser_utils.StringToIntegersSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChangeCommand implements Command{
    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, FileNotOpenedException, InvalidStudentException, InvalidChangeOptionException, InvalidProgramException, InvalidGroupException, InvalidYearChangeException, InvalidStatusException, BadStudentException, UnallowedProgramChangeException, UnallowedProgramChangeGradesException, AlreadyDoneException {
        if(args.length < 3){
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

        String option = args[1].toString();
        if(option.equalsIgnoreCase("program")) {
            String programName = args[2].toString();
            Program program = ProgramNameToProgram.getProgram(programName);
            if(program==null) {
                throw new InvalidProgramException();
            }

            if(programName.equalsIgnoreCase(student.getProgramName())) {
                throw new AlreadyDoneException();
            }

            Set<MandatoryCourse> coursesToBePassed = new HashSet<>();
            for(Map.Entry<MandatoryCourse, String> current: program.getMandatoryCourseMap().entrySet()) {
                Set<Integer> yearsSet = StringToIntegersSet.stringToSet(current.getValue());

                if(Collections.max(yearsSet) <= student.getYear()) {
                    coursesToBePassed.add(current.getKey());
                }
            }

            for(MandatoryCourse current: coursesToBePassed) {
                if(!student.getMandatoryCourseMap().containsKey(current)) {
                    throw new UnallowedProgramChangeException();
                }
            }

            for(Map.Entry<MandatoryCourse, String> current: program.getMandatoryCourseMap().entrySet()) {
                Set<Integer> yearsSet = StringToIntegersSet.stringToSet(current.getValue());

                if(Collections.max(yearsSet) < student.getYear() && student.getMandatoryCourseMap().get(current.getKey()) < 3) {
                    throw new UnallowedProgramChangeGradesException();
                }
            }

            student.setProgramName(program.getName());
            System.out.println("Student with fn " + fn + " successfully moved to program " + program.getName());

        }
        else if(option.equalsIgnoreCase("group")) {
            int group = Integer.parseInt(args[2].toString());

            if(group == student.getGroup()) {
                throw new AlreadyDoneException();
            }

            if(group < 0 || group > student.getProgram().getNumberOfGroups()) {
                throw new InvalidGroupException();
            }

            student.setGroup(group);
            System.out.println("Student with fn " + fn + " successfully moved to group " + group);
        }
        else if(option.equalsIgnoreCase("year")) {
            int year = Integer.parseInt(args[2].toString());
            if(year == student.getYear()) {
                throw new AlreadyDoneException();
            }

            if(year != student.getYear() + 1 || year > student.getProgram().getNumberOfYears()) {
                throw new InvalidYearChangeException();
            }

            int numberOfNotTakenCourses = 0;
            for(Map.Entry<MandatoryCourse, Integer> current: student.getMandatoryCourseMap().entrySet()) {
                if(current.getValue() < 3) {
                    numberOfNotTakenCourses++;
                }
            }

            if(numberOfNotTakenCourses > 2) {
                throw new BadStudentException();
            }

            student.setYear(year);
            student.updateMandatoryCourses();
            student.updateAverageGrade();
            System.out.println("Student with fn " + fn + " advanced successfully to year " + student.getYear());
        }
        else{
            throw new InvalidChangeOptionException();
        }
    }
}
