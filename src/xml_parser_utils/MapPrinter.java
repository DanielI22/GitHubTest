package xml_parser_utils;

import bg.tu_varna.sit.MandatoryCourse;
import bg.tu_varna.sit.OptionalCourse;

import java.util.Map;

public class MapPrinter {
    public static String printGradesMandatory(Map<MandatoryCourse, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<MandatoryCourse, Integer> current:  map.entrySet()) {
            sb.append("     ").append(current.getKey());
            sb.append("     ").append("Grade: ");
            if(current.getValue() == 0) {
                sb.append("None");
            }
            else{
                sb.append(current.getValue());
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static String printGradesOptional(Map<OptionalCourse, Integer> map) {
        if(map.isEmpty()) return "None\n";
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<OptionalCourse, Integer> current:  map.entrySet()) {
            sb.append("     ").append(current.getKey());
            sb.append("     ").append("Grade: ");
            if(current.getValue() == 0) {
                sb.append("None");
            }
            else if(current.getValue() == 2){
                sb.append(current.getValue());
                sb.append("     ").append("Credits earned: 0");
            }
            else {
                sb.append(current.getValue());
                sb.append("     ").append("Credits earned: ").append(current.getKey().getCredits());
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
