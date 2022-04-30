package xml_parser_utils;

import bg.tu_varna.sit.MandatoryCourse;
import bg.tu_varna.sit.OptionalCourse;

import java.util.*;

public class MapPrinter {
    public static String printGradesMandatory(Map<MandatoryCourse, Integer> map) {
        List<Map.Entry<MandatoryCourse, Integer>> list =
                new LinkedList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());
        HashMap<MandatoryCourse, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<MandatoryCourse, Integer> current : list) {
            temp.put(current.getKey(), current.getValue());
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<MandatoryCourse, Integer> current:  temp.entrySet()) {
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

        List<Map.Entry<OptionalCourse, Integer>> list =
                new LinkedList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());
        HashMap<OptionalCourse, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<OptionalCourse, Integer> current : list) {
            temp.put(current.getKey(), current.getValue());
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<OptionalCourse, Integer> current:  temp.entrySet()) {
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
