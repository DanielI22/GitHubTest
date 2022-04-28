package command_lines;

import exceptions.*;

public interface Command {
    void execute(Object[] args) throws FileNotOpenedException, InvalidFileOrFilePathException, InvalidArgumentsException, InvalidProgramException, InvalidGroupException, StudentAlreadyExistsException, InvalidStudentException, InvalidStatusException, BadStudentException, InvalidGraduationCreditsException, InvalidGraduationCoursesException, InvalidGraduationYearException, InvalidChangeOptionException, InvalidYearChangeException, UnallowedProgramChangeException, UnallowedProgramChangeGradesException, AlreadyDoneException, InvalidYearException;
}
