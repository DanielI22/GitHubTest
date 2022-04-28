package bg.tu_varna.sit;
import xml_parser_utils.MapPrinter;
import xml_parser_utils.ProgramNameToProgram;
import xml_parser_utils.StringToIntegersSet;

import java.util.*;

public class Student {
    private String name;
    private String fn;
    private int year;
    private String programName;
    private int group;
    private StudentStatus status = StudentStatus.ACTIVE;
    private double averageGrade;
    private Map<MandatoryCourse, Integer> mandatoryCourseMap = new HashMap<>();
    private Map<OptionalCourse, Integer> optionalCourseMap = new HashMap<>();
    private int credits;

    public Student() {
    }

    public Student(String name, String fn) {
        this.name = name;
        this.fn = fn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getProgramName() {
        return programName;
    }

    public Program getProgram() {
        return ProgramNameToProgram.getProgram(this.programName);
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }


    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Map<MandatoryCourse, Integer> getMandatoryCourseMap() {
        return mandatoryCourseMap;
    }

    public void setMandatoryCourseMap(Map<MandatoryCourse, Integer> mandatoryCourseMap) {
        this.mandatoryCourseMap = mandatoryCourseMap;
    }


    public Map<OptionalCourse, Integer> getOptionalCourseMap() {
        return optionalCourseMap;
    }

    public void setOptionalCourseMap(Map<OptionalCourse, Integer> optionalCourseMap) {
        this.optionalCourseMap = optionalCourseMap;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(fn, student.fn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fn);
    }

    @Override
    public String toString() {
        return "Student Info:\n" +
                "Faculty number     " + fn + "\n"+
                "Name               " + name + "\n"+
                "Status             " + status + "\n"+
                "Program            " + programName + "\n"+
                "Year               " + year + "\n"+
                "Group              " + group + "\n"+
                "Mandatory courses:\n" +
                MapPrinter.printGradesMandatory(mandatoryCourseMap) +
                "Optional courses:\n" +
                MapPrinter.printGradesOptional(optionalCourseMap) +
                "Credits            " + credits + "\n"+
                "Credits for graduation: " + this.getProgram().getMinCredits() + "\n"+
                "Average grade      " + averageGrade;
    }

    public void updateMandatoryCourses() {
        for(Map.Entry<MandatoryCourse, String> current: this.getProgram().getMandatoryCourseMap().entrySet()) {
            Set<Integer> yearsSet = StringToIntegersSet.stringToSet(current.getValue());

            if(Collections.max(yearsSet) == this.year) {
                this.getMandatoryCourseMap().put(current.getKey(),0);
            }
        }
    }

    public void updateAverageGrade() {
        int sum = 0;
        int br = 0;
        for(Map.Entry<MandatoryCourse, Integer> current: this.getMandatoryCourseMap().entrySet()) {
            br++;
            if(current.getValue() == 0) {
                sum+=2;
            }
            else {
                sum += current.getValue();
            }
        }
        for(Map.Entry<OptionalCourse, Integer> current: this.getOptionalCourseMap().entrySet()) {
            br++;
            if(current.getValue() == 0) {
                sum+=2;
            }
            else {
                sum += current.getValue();
            }
        }
        this.setAverageGrade((double)sum/br);
    }

}
