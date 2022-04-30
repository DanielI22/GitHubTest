package command_lines;


import bg.tu_varna.sit.*;
import exceptions.FileNotOpenedException;
import exceptions.InvalidArgumentsException;
import exceptions.InvalidCourseNameException;

import java.util.*;
import java.util.stream.Collectors;

public class ProtocolCommand implements Command {
    @Override
    public void execute(Object[] args) throws InvalidArgumentsException, FileNotOpenedException, InvalidCourseNameException {
        if(args.length < 1){
            throw new InvalidArgumentsException();
        }

        if(!OpenCommand.openedFile){
            throw new FileNotOpenedException();
        }

        String course = args[0].toString();

        MandatoryCourse mandatoryCourse = null;
        OptionalCourse optionalCourse = null;
        boolean courseExist = false;
        for(Program currentProgram: StudentServiceSystem.getInstance().getMainProgramSet()) {
            for(MandatoryCourse currentCourse: currentProgram.getMandatoryCourseMap().keySet()) {
                if (currentCourse.getName().equalsIgnoreCase(course)) {
                    courseExist = true;
                    mandatoryCourse = currentCourse;
                    break;
                }
            }
            for(OptionalCourse currentCourse: currentProgram.getOptionalCourseMap().keySet()) {
                if (currentCourse.getName().equalsIgnoreCase(course)) {
                    courseExist = true;
                    optionalCourse = currentCourse;
                    break;
                }
            }
        }

        if(!courseExist) {
            throw new InvalidCourseNameException();
        }


        Set<Student> studentSet = new HashSet<>();
        for(Student current: StudentServiceSystem.getInstance().getMainStudentSet()) {
            if(current.getMandatoryCourseMap().containsKey(mandatoryCourse)) {
                studentSet.add(current);
            }
        }
        for(Student current: StudentServiceSystem.getInstance().getMainStudentSet()) {
            if(current.getOptionalCourseMap().containsKey(optionalCourse)) {
                studentSet.add(current);
            }
        }

        List<Student> studentList = new ArrayList<>(studentSet);
        studentList.sort(Comparator.comparing(Student::getFn));
        if(studentList.isEmpty()) {
            System.out.println("None of the students have enrolled in " + course);
        }


        Map<String, Map<Integer, List<Student>>> studentsByProgramYear;
        studentsByProgramYear = studentList
                .stream().collect(Collectors.groupingBy(Student::getProgramName, Collectors.groupingBy(Student::getYear)));


        int i = 1;
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Map<Integer, List<Student>>> currentProgram: studentsByProgramYear.entrySet()) {
            for(Map.Entry<Integer, List<Student>> currentYear: currentProgram.getValue().entrySet()){
                sb.append("\nProtocol ").append(i).append("\n");
                sb.append("Program: ").append(currentProgram.getKey()).append("\n");
                sb.append("Year: ").append(currentYear.getKey()).append("\n");
                for(Student currentStudent: currentYear.getValue()) {
                    sb.append("\t").append(currentStudent);
                }
                i++;
            }
        }
        System.out.println(sb);
    }
}
