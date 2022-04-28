package xml_parser_utils;

import bg.tu_varna.sit.Program;
import bg.tu_varna.sit.StudentServiceSystem;

public class ProgramNameToProgram {
    public static Program getProgram(String programName) {
        for(Program current : StudentServiceSystem.getInstance().getMainProgramSet()) {
            if(current.getName().equalsIgnoreCase(programName)) {
                return current;
            }
        }
        return null;
    }
}
