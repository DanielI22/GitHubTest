package xml_parser_utils;

import bg.tu_varna.sit.Student;
import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.InvalidStudentException;

public class FnToStudent {

    public static Student findStudent(String fn) throws InvalidStudentException {
        for (Student current: StudentServiceSystem.getInstance().getMainStudentSet()) {
            if(current.getFn().equalsIgnoreCase(fn)) {
               return current;
            }
        }
        throw new InvalidStudentException();
    }
}
