package aoc.day05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


import aoc.Day;
import aoc.Utils;

public class Day05 implements Day {

    @Override
    public String part1(final String input) {
        final List<String> inputLines = Utils.splitLines(input);
        final List<List<Integer>> rulesList = inputLines.stream().takeWhile(s -> !s.isBlank())
                .map(r -> Arrays.asList(r.split("\\|")).stream().map(Integer::valueOf).toList()).toList();

        final List<List<Integer>> updatesList = inputLines.stream().dropWhile(s -> !s.isBlank())
                .filter(s -> !s.isBlank())
                .map(r -> Arrays.asList(r.split(",")).stream().map(Integer::valueOf).toList()).toList();
        int middleSum = 0;
        for (final List<Integer> updates : updatesList) {
            boolean allOK = true;
            for (final List<Integer> rule : rulesList) {
                final int posl = this.getPos(updates, rule.get(0));
                final int posr = this.getPos(updates, rule.get(1));
                if (posl >= 0 && posr >= 0) {
                    if (posl >= posr) {
                        allOK = false;
                        break;
                    }
                }
            }
            if (allOK) {
                middleSum += updates.get(updates.size() / 2);
            }

        }
        return String.valueOf(middleSum);
    }

    @Override
    public String part2(final String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'part2'");
    }

    private int getPos(final List<Integer> elements, final int value) {
        return IntStream.range(0, elements.size()).filter(i -> elements.get(i).equals(value))
                .findFirst().orElse(-1);
    }

}
