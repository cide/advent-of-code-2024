package aoc;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<String> splitLines(final String input) {
        return Arrays.asList(input.split("\n"));
    } 

    public static char[][] getCharMatrix(final String input) {
        final List<String> lines = Utils.splitLines(input);
        final char[][] matrix = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i).toCharArray();
        }
        return matrix;
    }

}
