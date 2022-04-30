package command_lines;

import bg.tu_varna.sit.*;
import exceptions.*;
import xml_parser_utils.FnToStudent;
import xml_parser_utils.StringToIntegersSet;

import java.util.Map;
import java.util.Set;

public class EnrollInCommand implements Command {
    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, FileNotOpenedException, InvalidStudentException, InvalidStatusException, InvalidCourseNameException, InvalidCourseEnrollException, CourseAlreadyEnrolledException {
        if(args.length < 2){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String fn = args[0].toString();
        String course = args[1].toString();

        Student student = FnToStudent.findStudent(fn);

        if(!student.getStatus().equals(StudentStatus.ACTIVE)) {
            throw new InvalidStatusException();
        }


        boolean courseExist = false;
        for(Program currentProgram: StudentServiceSystem.getInstance().getMainProgramSet()) {
            for(MandatoryCourse currentCourse: currentProgram.getMandatoryCourseMap().keySet()) {
                if (currentCourse.getName().equals(course)) {
                    courseExist = true;
                    break;
                }
            }
            for(OptionalCourse currentCourse: currentProgram.getOptionalCourseMap().keySet()) {
                if (currentCourse.getName().equals(course)) {
                    courseExist = true;
                    break;
                }
            }
        }

        if(!courseExist) {
            throw new InvalidCourseNameException();
        }

        boolean alreadyExist = false;
        for(MandatoryCourse current: student.getMandatoryCourseMap().keySet()) {
            if ((current.getName().equalsIgnoreCase(course))) {
                alreadyExist = true;
                break;
            }
        }
        for(OptionalCourse current: student.getOptionalCourseMap().keySet()) {
            if ((current.getName().equalsIgnoreCase(course))) {
                alreadyExist = true;
                break;
            }
        }

        if(alreadyExist) {
            throw new CourseAlreadyEnrolledException();
        }


        boolean isAdded = false;
        for (Program currentProgram: StudentServiceSystem.getInstance().getMainProgramSet()) {
            if(currentProgram.equals(student.getProgram())) {
                for (Map.Entry<MandatoryCourse, String> currentCourse: currentProgram.getMandatoryCourseMap().entrySet()) {
                    Set<Integer> currentCourseYearsSet = StringToIntegersSet.stringToSet(currentCourse.getValue());
                    if(currentCourse.getKey().getName().equalsIgnoreCase(course) && currentCourseYearsSet.contains(student.getYear()) ) {
                        System.out.println("Student with fn " + fn + " enrolled in " + course + " successfully!");
                        student.getMandatoryCourseMap().put(currentCourse.getKey(), 0);
                        student.updateAverageGrade();
                        isAdded = true;
                        break;
                    }
                }
                for (Map.Entry<OptionalCourse, String> currentCourse: currentProgram.getOptionalCourseMap().entrySet()) {
                    Set<Integer> currentCourseYearsSet = StringToIntegersSet.stringToSet(currentCourse.getValue());
                    if(currentCourse.getKey().getName().equalsIgnoreCase(course) && currentCourseYearsSet.contains(student.getYear())) {
                        System.out.println("Student with fn " + fn + " enrolled in " + course + " successfully!");
                        student.getOptionalCourseMap().put(currentCourse.getKey(), 0);
                        student.updateAverageGrade();
                        isAdded = true;
                        break;
                    }
                }
            }
        }

        if(!isAdded) {
            throw new InvalidCourseEnrollException();
        }
    }
}
