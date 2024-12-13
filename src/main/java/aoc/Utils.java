package aoc;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<String> splitLines(final String input) {
        return Arrays.asList(input.split("\n"));
    } 

    public static String[] splitColumns(final String line) {
        return line.split(" {3}");
    }

}
