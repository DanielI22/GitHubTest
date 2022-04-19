package bg.tu_varna.sit;

import java.util.*;

public class Program {
    private String name;
    private HashMap<MandatoryCourse, String> mandatoryCourseMap = new HashMap<>();
    private HashMap<OptionalCourse, String> optionalCourseMap = new HashMap<>();
    private int minCredits;

    public Program() {
    }

    public Program(String name) {
        this.name = name;
    }

    public Program(String name, int minCredits) {
        this.name = name;
        this.minCredits = minCredits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<MandatoryCourse,String> getMandatoryCourseMap() {
        return mandatoryCourseMap;
    }

    public void setMandatoryCourseMap(HashMap<MandatoryCourse, String> mandatoryCourseMap) {
        this.mandatoryCourseMap = mandatoryCourseMap;
    }

    public HashMap<OptionalCourse, String> getOptionalCourseMap() {
        return optionalCourseMap;
    }

    public void setOptionalCourseMap(HashMap<OptionalCourse, String> optionalCourseMap) {
        this.optionalCourseMap = optionalCourseMap;
    }

    public int getMinCredits() {
        return minCredits;
    }

    public void setMinCredits(int minCredits) {
        this.minCredits = minCredits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Program)) return false;
        Program program = (Program) o;
        return Objects.equals(name, program.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", mandatoryCourseMap=" + mandatoryCourseMap +
                ", optionalCourseMap=" + optionalCourseMap +
                ", minCredits=" + minCredits +
                '}';
    }
}
