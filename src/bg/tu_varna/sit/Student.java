package bg.tu_varna.sit;
import java.util.*;

public class Student {
    private String name;
    private String fn;
    private int course;
    private Program program;
    private int group;
    private StudentStatus status;
    private double averageGrade;
    private Map<MandatoryDiscipline, Integer> mandatoryDisciplineSet = new HashMap<>();
    private Map<OptionalDiscipline, Integer> optionalDisciplineSet = new HashMap<>();


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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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

    public Map<MandatoryDiscipline, Integer> getMandatoryDisciplineSet() {
        return mandatoryDisciplineSet;
    }

    public void setMandatoryDisciplineSet(Map<MandatoryDiscipline, Integer> mandatoryDisciplineSet) {
        this.mandatoryDisciplineSet = mandatoryDisciplineSet;
    }

    public Map<OptionalDiscipline, Integer> getOptionalDisciplineSet() {
        return optionalDisciplineSet;
    }

    public void setOptionalDisciplineSet(Map<OptionalDiscipline, Integer> optionalDisciplineSet) {
        this.optionalDisciplineSet = optionalDisciplineSet;
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
}
