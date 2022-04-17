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
        mainStudentSet.add(new Student("George"));

        MandatoryDiscipline discipline1 = new MandatoryDiscipline("Base programming");
        MandatoryDiscipline discipline2 = new MandatoryDiscipline("Database");
        MandatoryDiscipline discipline3 = new MandatoryDiscipline("Web design");
        MandatoryDiscipline discipline4 = new MandatoryDiscipline("Electronics");
        MandatoryDiscipline discipline5 = new MandatoryDiscipline("Algorithms");
        MandatoryDiscipline discipline6 = new MandatoryDiscipline("OOP");
        MandatoryDiscipline discipline7 = new MandatoryDiscipline("Maths");
        MandatoryDiscipline discipline8 = new MandatoryDiscipline("Digital systems");
        MandatoryDiscipline discipline9 = new MandatoryDiscipline("Analog systems");
        MandatoryDiscipline discipline10 = new MandatoryDiscipline("Computer Architecture");

        OptionalDiscipline odiscipline1 = new OptionalDiscipline("English", 2);
        OptionalDiscipline odiscipline2 = new OptionalDiscipline("French", 8);
        OptionalDiscipline odiscipline3 = new OptionalDiscipline("Microprocessors", 6);
        OptionalDiscipline odiscipline4 = new OptionalDiscipline("Geometry", 4);
        OptionalDiscipline odiscipline5 = new OptionalDiscipline("Calculus", 7);

        HashMap<MandatoryDiscipline, HashSet<Integer>> map1 = new HashMap<>();
        map1.put(discipline1, new HashSet<>(Arrays.asList(1)));
        map1.put(discipline2, new HashSet<>(Arrays.asList(2)));
        map1.put(discipline3, new HashSet<>(Arrays.asList(3)));
        map1.put(discipline4, new HashSet<>(Arrays.asList(1,2)));
        map1.put(discipline5, new HashSet<>(Arrays.asList(2,3)));
        map1.put(discipline6, new HashSet<>(Arrays.asList(1,3)));

        HashMap<OptionalDiscipline, HashSet<Integer>> omap1 = new HashMap<>();
        omap1.put(odiscipline1, new HashSet<>(Arrays.asList(1)));
        omap1.put(odiscipline3, new HashSet<>(Arrays.asList(2)));
        omap1.put(odiscipline4, new HashSet<>(Arrays.asList(2,3)));

        Program program1 = new Program("SIT", 6);
        program1.setMandatoryDisciplineMap(map1);
        program1.setOptionalDisciplineMap(omap1);


        HashMap<MandatoryDiscipline, HashSet<Integer>> map2 = new HashMap<>();
        map2.put(discipline1, new HashSet<>(Arrays.asList(1)));
        map2.put(discipline7, new HashSet<>(Arrays.asList(2)));
        map2.put(discipline8, new HashSet<>(Arrays.asList(3)));
        map2.put(discipline9, new HashSet<>(Arrays.asList(1,2)));
        map2.put(discipline10, new HashSet<>(Arrays.asList(2,3)));

        HashMap<OptionalDiscipline, HashSet<Integer>> omap2 = new HashMap<>();
        omap1.put(odiscipline1, new HashSet<>(Arrays.asList(1)));
        omap1.put(odiscipline2, new HashSet<>(Arrays.asList(2)));
        omap1.put(odiscipline5, new HashSet<>(Arrays.asList(2,3)));

        Program program2 = new Program("KST", 10);
        program2.setMandatoryDisciplineMap(map2);
        program2.setOptionalDisciplineMap(omap2);

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
