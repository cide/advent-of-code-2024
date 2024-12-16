package aoc.day01;

import java.util.List;

import aoc.Day;
import aoc.Utils;

public class Day01 implements Day {

    @Override
    public String part1(final String input) {
        final List<String> lines = Utils.splitLines(input);
        final List<Integer> leftIntegers = getIntegerCol(lines, 0);
        final List<Integer> rightIntegers = getIntegerCol(lines, 1);

        int distance = 0;
        for (int i = 0; i < leftIntegers.size(); i++) {
            distance += Math.abs(leftIntegers.get(i) - rightIntegers.get(i));
        }
        return String.valueOf(distance);
    }

    @Override
    public String part2(final String input) {
        final List<String> lines = Utils.splitLines(input);
        final List<Integer> leftIntegers = getIntegerCol(lines, 0);
        final List<Integer> rightIntegers = getIntegerCol(lines, 1);

        int similarity = 0;
        for (Integer left : leftIntegers) {
            similarity += left * rightIntegers.stream().filter(r -> r.equals(left)).toList().size();
        }

        return String.valueOf(similarity);
    }

    /**
     * Returns the column separated by " " as a sorted {@link List} of
     * {@link Integers}.
     * 
     * @param lines
     * @param col
     * @return
     */
    private List<Integer> getIntegerCol(List<String> lines, int col) {
        return lines.stream().filter(s -> s.contains("  "))
                .map(s -> Integer.valueOf(s.split(" {3}")[col])).sorted()
                .toList();
    }

}
