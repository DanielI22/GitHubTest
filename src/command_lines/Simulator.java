package command_lines;

import bg.tu_varna.sit.*;
import java.util.HashMap;

public class Simulator {

    public static void simulate() {
        //ALL 1
        MandatoryCourse discipline1 = new MandatoryCourse("Basic Mathematics");
        MandatoryCourse discipline2 = new MandatoryCourse("Computer Fundamentals");
        MandatoryCourse discipline3 = new MandatoryCourse("Programming Fundamentals");
        MandatoryCourse discipline4 = new MandatoryCourse("English");

        //SIT CST 2
        MandatoryCourse discipline5 = new MandatoryCourse("Mathematics for Computing");
        MandatoryCourse discipline6 = new MandatoryCourse("Data Structures");
        MandatoryCourse discipline7 = new MandatoryCourse("Object-Oriented Programming");

        //ICT 2
//        MandatoryCourse discipline5 = new MandatoryCourse("Mathematics for Computing");
        MandatoryCourse discipline8 = new MandatoryCourse("Electrical Engineering");
        MandatoryCourse discipline9 = new MandatoryCourse("Electrical Measurements");

        //SIT 3
        MandatoryCourse discipline10 = new MandatoryCourse("Microprocessors");
        MandatoryCourse discipline11 = new MandatoryCourse("System Analysis");
        MandatoryCourse discipline12 = new MandatoryCourse("Programming Systems");

        //CST 3
//        MandatoryCourse discipline10 = new MandatoryCourse("Microprocessors");
        MandatoryCourse discipline13 = new MandatoryCourse("Information Encryption");
        MandatoryCourse discipline14 = new MandatoryCourse("Operating Systems");

        //ICT 3
        MandatoryCourse discipline15 = new MandatoryCourse("Communication Networks");
        MandatoryCourse discipline16 = new MandatoryCourse("Radio Communications");
        MandatoryCourse discipline17 = new MandatoryCourse("Analog Circuits");

        //SIT 4
        MandatoryCourse discipline18 = new MandatoryCourse("Internet Technologies");
//        MandatoryCourse discipline12 = new MandatoryCourse("Programming Systems");

        //CST 4
        MandatoryCourse discipline19 = new MandatoryCourse("Web Programming");
//        MandatoryCourse discipline14 = new MandatoryCourse("Operating Systems");

        //IKT 4
        MandatoryCourse discipline20 = new MandatoryCourse("Video Technologies");
//        MandatoryCourse discipline17 = new MandatoryCourse("Analog Circuits");


        //SIT CST 2 3 4
        OptionalCourse odiscipline1 = new OptionalCourse("Sport", 4);
        OptionalCourse odiscipline2 = new OptionalCourse("Office Systems", 8);
        OptionalCourse odiscipline3 = new OptionalCourse("Information Management", 6);
        OptionalCourse odiscipline4 = new OptionalCourse("Embedded Microcontrollers", 7);

        //ICT 3 4
        OptionalCourse odiscipline5 = new OptionalCourse("Optic Cable Systems", 5);
        OptionalCourse odiscipline6 = new OptionalCourse("Video Systems", 5);
        OptionalCourse odiscipline7 = new OptionalCourse("Technical Safety", 7);

        HashMap<MandatoryCourse, String> sitmap = new HashMap<>();
        sitmap.put(discipline1, "1");
        sitmap.put(discipline2, "1");
        sitmap.put(discipline3, "1");
        sitmap.put(discipline4, "1");
        sitmap.put(discipline5, "2");
        sitmap.put(discipline6, "2");
        sitmap.put(discipline7, "2");
        sitmap.put(discipline10, "3");
        sitmap.put(discipline11, "3");
        sitmap.put(discipline12, "3 4");
        sitmap.put(discipline18, "4");

        HashMap<OptionalCourse, String> sitcstomap = new HashMap<>();
        sitcstomap.put(odiscipline1,"2 3 4");
        sitcstomap.put(odiscipline2,"2 3 4");
        sitcstomap.put(odiscipline3,"2 3 4");
        sitcstomap.put(odiscipline4, "2 3 4");

        Program program1 = new Program("SIT", 15);
        program1.setMandatoryCourseMap(sitmap);
        program1.setOptionalCourseMap(sitcstomap);


        HashMap<MandatoryCourse, String> cstmap = new HashMap<>();
        cstmap.put(discipline1, "1");
        cstmap.put(discipline2, "1");
        cstmap.put(discipline3, "1");
        cstmap.put(discipline4, "1");
        cstmap.put(discipline5, "2");
        cstmap.put(discipline6, "2");
        cstmap.put(discipline7, "2");
        cstmap.put(discipline10, "3");
        cstmap.put(discipline13, "3");
        cstmap.put(discipline14, "3 4");
        cstmap.put(discipline19, "4");


        Program program2 = new Program("CST", 12);
        program2.setMandatoryCourseMap(cstmap);
        program2.setOptionalCourseMap(sitcstomap);


        HashMap<MandatoryCourse, String> ictmap = new HashMap<>();
        ictmap.put(discipline1, "1");
        ictmap.put(discipline2, "1");
        ictmap.put(discipline3, "1");
        ictmap.put(discipline4, "1");
        ictmap.put(discipline5, "2");
        ictmap.put(discipline8, "2");
        ictmap.put(discipline9, "2");
        ictmap.put(discipline15, "3");
        ictmap.put(discipline16, "3");
        ictmap.put(discipline17, "3 4");
        ictmap.put(discipline20, "4");

        HashMap<OptionalCourse, String> ictomap = new HashMap<>();
        ictomap.put(odiscipline5,"3 4");
        ictomap.put(odiscipline6,"3 4");
        ictomap.put(odiscipline7,"3 4");


        Program program3 = new Program("ICT", 10);
        program3.setMandatoryCourseMap(ictmap);
        program3.setOptionalCourseMap(ictomap);

        StudentServiceSystem.getInstance().getMainProgramSet().add(program1);
        StudentServiceSystem.getInstance().getMainProgramSet().add(program2);
        StudentServiceSystem.getInstance().getMainProgramSet().add(program3);

        System.out.println("Successfully simulated programs.");
    }
}
