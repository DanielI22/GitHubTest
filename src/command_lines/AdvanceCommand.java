package command_lines;

import bg.tu_varna.sit.MandatoryCourse;
import bg.tu_varna.sit.Student;
import bg.tu_varna.sit.StudentStatus;
import exceptions.*;
import xml_parser_utils.FnToStudent;

import java.util.Map;

public class AdvanceCommand implements Command{
    @Override
    public void execute(Object[] args) throws FileNotOpenedException, InvalidArgumentsException, InvalidStudentException, InvalidStatusException, BadStudentException, InvalidGraduationCreditsException, InvalidGraduationCoursesException {
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
        else if(student.getYear() < student.getProgram().getNumberOfYears()) {

            if(numberOfNotTakenCourses > 2) {
                throw new BadStudentException();
            }

            student.setYear(student.getYear()+1);
            student.updateMandatoryCourses();
            student.updateAverageGrade();
            System.out.println("Student with fn " + fn + " advanced successfully to year " + student.getYear());
        }
    }
}
