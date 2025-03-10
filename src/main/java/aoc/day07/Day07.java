package aoc.day07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.Day;
import aoc.Utils;

public class Day07 implements Day {

    private Map<Integer, Operator[]> operatorMap = new HashMap<>();

    @Override
    public String part1(final String input) {
        final List<String> inputLines = Utils.splitLines(input);

        // TODO: maximale Anzahl Operatoren bestimmen
        // Map aller Operatorkombinationen aufbauen

        final int totalSum = 0;
        for (final String line : inputLines) {
            final int sum = Integer.valueOf(line.split(":")[0]);
            List<String> numberStrings = Arrays.asList(line.split(":")[1].trim().split(" "));
            final List<Integer> numbers = numberStrings.stream().map(String::trim)
                    .map(Integer::valueOf)
                    .toList();
            // TODO:
            //
        }
        return String.valueOf(totalSum);
    }

    @Override
    public String part2(final String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'part2'");
    }

    /**
     * Returns a list of all combinations of {@link Operator}s.
     * 
     * @param length - number of operators
     * @return
     */
    private List<Operator[]> getOperatorAllCombinations(int length) {
        // TODO: Operator Array 
    }

    /**
     * Gets a combination of number {@link Operator}s represented by the bitMask
     * 
     * @param length  - number of operators
     * @param bitMask - bitMask representing the combination of Operators
     * 
     * @return
     */
    private Operator[] getOperatorCombination(int length, int bitMask) {
        Operator[] operators = new Operator[];
    }

    enum Operator {
        ADD, MULTIPLY;
    }

}
