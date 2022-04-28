package exceptions;

import bg.tu_varna.sit.Student;

public class InvalidGraduationCreditsException extends Exception {
    public InvalidGraduationCreditsException(Student student) {
        int neededCredits = student.getProgram().getMinCredits() - student.getCredits();
        System.out.println("Student need " + neededCredits + " more credits from optional courses to graduate");
    }
}
