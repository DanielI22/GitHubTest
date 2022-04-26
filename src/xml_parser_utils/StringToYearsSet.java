package xml_parser_utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringToYearsSet {
    public static Set<Integer> stringToSet(String string){
        Scanner scanner = new Scanner(string);
        Set<Integer> yearsSet = new HashSet<>();
        while (scanner.hasNextInt()) {
            yearsSet.add(scanner.nextInt());
        }
        return yearsSet;
    }
}
