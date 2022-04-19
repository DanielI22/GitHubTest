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

    public void simulatePrograms() {
        mainStudentSet.add(new Student("George", "001"));

        MandatoryCourse discipline1 = new MandatoryCourse("Base programming");
        MandatoryCourse discipline2 = new MandatoryCourse("Database");
        MandatoryCourse discipline3 = new MandatoryCourse("Web design");
        MandatoryCourse discipline4 = new MandatoryCourse("Electronics");
        MandatoryCourse discipline5 = new MandatoryCourse("Algorithms");
        MandatoryCourse discipline6 = new MandatoryCourse("OOP");
        MandatoryCourse discipline7 = new MandatoryCourse("Maths");
        MandatoryCourse discipline8 = new MandatoryCourse("Digital systems");
        MandatoryCourse discipline9 = new MandatoryCourse("Analog systems");
        MandatoryCourse discipline10 = new MandatoryCourse("Computer Architecture");

        OptionalCourse odiscipline1 = new OptionalCourse("English", 2);
        OptionalCourse odiscipline2 = new OptionalCourse("French", 8);
        OptionalCourse odiscipline3 = new OptionalCourse("Microprocessors", 6);
        OptionalCourse odiscipline4 = new OptionalCourse("Geometry", 4);
        OptionalCourse odiscipline5 = new OptionalCourse("Calculus", 7);

        HashMap<MandatoryCourse, String> map1 = new HashMap<>();
        map1.put(discipline1, "1");
        map1.put(discipline2, "2");
        map1.put(discipline3, "3");
        map1.put(discipline4, "1 2");
        map1.put(discipline5, "2 3");
        map1.put(discipline6,"1 3");

        HashMap<OptionalCourse, String> omap1 = new HashMap<>();
        omap1.put(odiscipline1,"1");
        omap1.put(odiscipline3,"2");
        omap1.put(odiscipline4, "2 3");

        Program program1 = new Program("SIT", 6);
        program1.setMandatoryCourseMap(map1);
        program1.setOptionalCourseMap(omap1);


        HashMap<MandatoryCourse, String> map2 = new HashMap<>();
        map2.put(discipline1,"1");
        map2.put(discipline7,"2");
        map2.put(discipline8,"3");
        map2.put(discipline9, "1 2");
        map2.put(discipline10, "2 3");

        HashMap<OptionalCourse,String> omap2 = new HashMap<>();
        omap2.put(odiscipline1, "1");
        omap2.put(odiscipline2, "2");
        omap2.put(odiscipline5,"2 3");

        Program program2 = new Program("KST", 10);
        program2.setMandatoryCourseMap(map2);
        program2.setOptionalCourseMap(omap2);

        mainProgramSet.add(program1);
        mainProgramSet.add(program2);
    }

    @Override
    public String toString() {
        return "StudentServiceSystem{" +
                "mainStudentSet=" + mainStudentSet +
                ", mainProgramSet=" + mainProgramSet +
                '}';
    }
}
