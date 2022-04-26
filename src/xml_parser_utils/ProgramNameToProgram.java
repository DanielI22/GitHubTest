package xml_parser_utils;

import bg.tu_varna.sit.Program;
import bg.tu_varna.sit.StudentServiceSystem;
import exceptions.InvalidProgramException;

public class ProgramNameToProgram {
    public static Program getProgram(String programName) throws InvalidProgramException {
        for(Program current : StudentServiceSystem.getInstance().getMainProgramSet()) {
            if(current.getName().equalsIgnoreCase(programName)) {
                return current;
            }
        }
        throw new InvalidProgramException();
    }
}
