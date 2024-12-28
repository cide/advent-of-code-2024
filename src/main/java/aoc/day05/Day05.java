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
        final List<List<Integer>> rulesList = this.getRules(inputLines);
        final List<List<Integer>> updatesList = this.getUpdates(inputLines);
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
        final List<String> inputLines = Utils.splitLines(input);
        final List<List<Integer>> rulesList = this.getRules(inputLines);
        final List<List<Integer>> updatesList = this.getUpdates(inputLines);
        int middleSum = 0;
        for (final List<Integer> updates : updatesList) {
            List<Integer> updatesReordered = updates.stream().toList();
            boolean reordered = false;
            boolean repeat = true;
            while (repeat) {
                for (final List<Integer> rule : rulesList) {
                    final List<Integer> updatesCopy = updatesReordered.stream().toList();
                    final int posl = this.getPos(updatesCopy, rule.get(0));
                    final int posr = this.getPos(updatesCopy, rule.get(1));
                    if (posl >= 0 && posr >= 0) {
                        if (posl >= posr) {
                            updatesReordered = IntStream.range(0, updatesCopy.size())
                                    .mapToObj(i -> updatesCopy.get(this.flipValue(i, posl, posr))).toList();
                            reordered = true;
                            repeat = true;
                            break;
                        }
                    }
                    repeat = false;
                }
            }
            if (reordered) {
                middleSum += updatesReordered.get(updatesReordered.size() / 2);
            }
        }
        return String.valueOf(middleSum);
    }

    private List<List<Integer>> getRules(final List<String> inputLines) {
        return inputLines.stream().takeWhile(s -> !s.isBlank())
                .map(r -> Arrays.asList(r.split("\\|")).stream().map(Integer::valueOf).toList()).toList();
    }

    private List<List<Integer>> getUpdates(final List<String> inputLines) {
        return inputLines.stream().dropWhile(s -> !s.isBlank())
                .filter(s -> !s.isBlank())
                .map(r -> Arrays.asList(r.split(",")).stream().map(Integer::valueOf).toList()).toList();
    }

    private int getPos(final List<Integer> elements, final int value) {
        return IntStream.range(0, elements.size()).filter(i -> elements.get(i).equals(value))
                .findFirst().orElse(-1);
    }

    private int flipValue(final int i, final int posl, final int posr) {
        if (posl == i) {
            return posr;
        } else if (posr == i) {
            return posl;
        } else {
            return i;
        }
    }

}
