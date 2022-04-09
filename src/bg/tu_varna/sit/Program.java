package bg.tu_varna.sit;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Program {
    private String name;
    private Map<MandatoryDiscipline, Set<Integer>> mandatoryDisciplineMap = new HashMap<>();
    private Map<OptionalDiscipline, Set<Integer>> optionalDisciplineMap = new HashMap<>();
    private int minCredits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<MandatoryDiscipline, Set<Integer>> getMandatoryDisciplineMap() {
        return mandatoryDisciplineMap;
    }

    public void setMandatoryDisciplineMap(Map<MandatoryDiscipline, Set<Integer>> mandatoryDisciplineMap) {
        this.mandatoryDisciplineMap = mandatoryDisciplineMap;
    }

    public Map<OptionalDiscipline, Set<Integer>> getOptionalDisciplineMap() {
        return optionalDisciplineMap;
    }

    public void setOptionalDisciplineMap(Map<OptionalDiscipline, Set<Integer>> optionalDisciplineMap) {
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
}
