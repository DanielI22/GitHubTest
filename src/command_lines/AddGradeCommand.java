package command_lines;


import bg.tu_varna.sit.*;
import exceptions.*;
import xml_parser_utils.FnToStudent;

import java.util.Map;

public class AddGradeCommand implements Command {
    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, FileNotOpenedException, InvalidStudentException, InvalidStatusException, InvalidCourseNameException, InvalidGradeException, InvalidCourseInMapException, GradeAlreadyAddedException {
        if(args.length < 3){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String fn = args[0].toString();
        String course = args[1].toString();
        int grade = Integer.parseInt(args[2].toString());

        Student student = FnToStudent.findStudent(fn);

        if(!student.getStatus().equals(StudentStatus.ACTIVE)) {
            throw new InvalidStatusException();
        }

        boolean courseExist = false;
        for(Program currentProgram: StudentServiceSystem.getInstance().getMainProgramSet()) {
            for(MandatoryCourse currentCourse: currentProgram.getMandatoryCourseMap().keySet()) {
                if (currentCourse.getName().equalsIgnoreCase(course)) {
                    courseExist = true;
                    break;
                }
            }
            for(OptionalCourse currentCourse: currentProgram.getOptionalCourseMap().keySet()) {
                if (currentCourse.getName().equalsIgnoreCase(course)) {
                    courseExist = true;
                    break;
                }
            }
        }

        if(!courseExist) {
            throw new InvalidCourseNameException();
        }

        if(grade < 2 || grade > 6) {
            throw new InvalidGradeException();
        }

        boolean exist = false;
        for(Map.Entry<MandatoryCourse, Integer> current: student.getMandatoryCourseMap().entrySet()) {
            if(current.getKey().getName().equalsIgnoreCase(course)) {
                exist=true;
                break;
            }
        }
        for(Map.Entry<OptionalCourse, Integer> current: student.getOptionalCourseMap().entrySet()) {
            if(current.getKey().getName().equalsIgnoreCase(course)) {
                exist=true;
                break;
            }
        }

        if(!exist) {
            throw new InvalidCourseInMapException();
        }

        boolean isAdded = false;
        for(Map.Entry<MandatoryCourse, Integer> current: student.getMandatoryCourseMap().entrySet()) {
            if(current.getKey().getName().equalsIgnoreCase(course) && (current.getValue()==0 || current.getValue()==2)) {
                student.getMandatoryCourseMap().put(current.getKey(),grade);
                student.updateAverageGrade();
                isAdded=true;
                System.out.println("Grade " + grade + " successfully added to course " + course + " of student with fn " + fn);
                break;
            }
        }
        for(Map.Entry<OptionalCourse, Integer> current: student.getOptionalCourseMap().entrySet()) {
            if(current.getKey().getName().equalsIgnoreCase(course) && (current.getValue()==0 || current.getValue()==2)) {
                student.getOptionalCourseMap().put(current.getKey(),grade);
                student.setCredits(student.getCredits() + current.getKey().getCredits());
                student.updateAverageGrade();
                isAdded=true;
                System.out.println("Grade " + grade + " successfully added to course " + course + " of student with fn " + fn);
                break;
            }
        }

        if(!isAdded) {
            throw new GradeAlreadyAddedException();
        }
    }
}
