package bg.tu_varna.sit;
import java.util.*;

public class Student {
    private String name;
    private String fn;
    private int year;
    private Program program;
    private int group;
    private StudentStatus status;
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", fn='" + fn + '\'' +
                ", year=" + year +
                ", program=" + program +
                ", group=" + group +
                ", status=" + status +
                ", averageGrade=" + averageGrade +
                ", mandatoryCourseMap=" + mandatoryCourseMap +
                ", optionalCourseMap=" + optionalCourseMap +
                ", credits=" + credits +
                '}';
    }
}
