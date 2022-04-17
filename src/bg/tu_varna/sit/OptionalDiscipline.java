package bg.tu_varna.sit;

public class OptionalDiscipline extends Discipline{
    private int credits;

    public OptionalDiscipline() {
    }

    public OptionalDiscipline(String name, int credits) {
        super(name);
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
