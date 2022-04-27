package command_lines;


import bg.tu_varna.sit.MandatoryCourse;
import bg.tu_varna.sit.Student;
import bg.tu_varna.sit.StudentStatus;
import exceptions.*;
import xml_parser_utils.FnToStudent;

import java.util.Map;

public class GraduateCommand implements Command{
    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, FileNotOpenedException, InvalidStatusException, InvalidStudentException, InvalidProgramException, InvalidGraduationCreditsException, InvalidGraduationCoursesException, InvalidGraduationYearException {
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

        int numberOfNotTakenCourses = 0;
        for(Map.Entry<MandatoryCourse, Integer> current: student.getMandatoryCourseMap().entrySet()) {
            if(current.getValue() < 3) {
                numberOfNotTakenCourses++;
            }
        }

        if(student.getYear() == student.getProgram().getNumberOfYears()) {
            if(numberOfNotTakenCourses == 0) {
                if(student.getCredits() >= student.getProgram().getMinCredits()) {
                    student.setStatus(StudentStatus.GRADUATED);
                    System.out.println("Student with fn " + fn + " graduated successfully");
                }
                else {
                    throw new InvalidGraduationCreditsException(student);
                }
            }
            else {
                throw new InvalidGraduationCoursesException();
            }
        }
        else{
            throw new InvalidGraduationYearException();
        }
    }
}
