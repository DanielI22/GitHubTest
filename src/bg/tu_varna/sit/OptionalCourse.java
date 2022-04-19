package bg.tu_varna.sit;

public class OptionalCourse extends Course {
    private int credits;

    public OptionalCourse() {
    }

    public OptionalCourse(String name, int credits) {
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
