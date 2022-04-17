package bg.tu_varna.sit;

import java.util.*;

public class Program {
    private String name;
    private HashMap<MandatoryDiscipline, HashSet<Integer>> mandatoryDisciplineMap = new HashMap<>();
    private HashMap<OptionalDiscipline, HashSet<Integer>> optionalDisciplineMap = new HashMap<>();
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

    public HashMap<MandatoryDiscipline, HashSet<Integer>> getMandatoryDisciplineMap() {
        return mandatoryDisciplineMap;
    }

    public void setMandatoryDisciplineMap(HashMap<MandatoryDiscipline, HashSet<Integer>> mandatoryDisciplineMap) {
        this.mandatoryDisciplineMap = mandatoryDisciplineMap;
    }

    public HashMap<OptionalDiscipline, HashSet<Integer>> getOptionalDisciplineMap() {
        return optionalDisciplineMap;
    }

    public void setOptionalDisciplineMap(HashMap<OptionalDiscipline, HashSet<Integer>> optionalDisciplineMap) {
        this.optionalDisciplineMap = optionalDisciplineMap;
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
                ", mandatoryDisciplineMap=" + mandatoryDisciplineMap +
                ", optionalDisciplineMap=" + optionalDisciplineMap +
                ", minCredits=" + minCredits +
                '}';
    }
}
