package bg.tu_varna.sit;

import java.util.*;

public class StudentServiceSystem {
    private static StudentServiceSystem systemInstance = new StudentServiceSystem();

    public static StudentServiceSystem getInstance() {
        return systemInstance;
    }

    public static void setSystemInstance(StudentServiceSystem studentServiceSystem) {
        systemInstance = studentServiceSystem;
    }

    private StudentServiceSystem() {
    }

    private  HashSet<Student> mainStudentSet = new HashSet<>();
    private  HashSet<Program> mainProgramSet = new HashSet<>();

    public HashSet<Student> getMainStudentSet() {
        return mainStudentSet;
    }

    public void setMainStudentSet(HashSet<Student> mainStudentSet) {
        this.mainStudentSet = mainStudentSet;
    }

    public HashSet<Program> getMainProgramSet() {
        return mainProgramSet;
    }

    public void setMainProgramSet(HashSet<Program> mainProgramSet) {
        this.mainProgramSet = mainProgramSet;
    }

    @Override
    public String toString() {
        return "StudentServiceSystem{" +
                "mainStudentSet=" + mainStudentSet +
                ", mainProgramSet=" + mainProgramSet +
                '}';
    }
}
