package aoc.day02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import aoc.Day;
import aoc.Utils;

public class Day02 implements Day {

    private int mindist = 1;
    private int maxdist = 3;

    @Override
    public String part1(final String input) {
        final List<String> lines = Utils.splitLines(input);
        int safereports = 0;
        for (String line : lines) {
            List<Integer> row = getIntegerRow(line);
            if (isSafe(row)) {
                safereports++;
            }
        }
        return String.valueOf(safereports);
    }

    @Override
    public String part2(final String input) {
        final List<String> lines = Utils.splitLines(input);
        int safereports = 0;
        for (String line : lines) {
            List<Integer> row = getIntegerRow(line);
            if (isSafe(row)) {
                safereports++;
            } else {
                for (int col = 0; col < row.size(); col++) {
                    final Integer remove = col;
                    List<Integer> reducedRow = IntStream.range(0, row.size()).filter(i -> i != remove)
                            .mapToObj(i -> row.get(i)).toList();
                    if (isSafe(reducedRow)) {
                        safereports++;
                        break;
                    }
                }
            }
        }
        return String.valueOf(safereports);
    }

    private List<Integer> getIntegerRow(String line) {
        return Arrays.asList(line.split(" ")).stream().map(s -> Integer.valueOf(s)).toList();
    }

    private boolean isSafe(List<Integer> row) {
        Boolean up = null;
        Integer last = null;
        Iterator<Integer> rowIt = row.iterator();
        boolean safe = true;
        while (rowIt.hasNext() && safe) {
            int current = rowIt.next();
            if (last != null) {
                if (up == null) {
                    up = last < current;
                }
                int dist = Math.abs(current - last);
                safe &= (up == last < current) && dist >= mindist && dist <= maxdist;
            }
            last = current;
        }
        return safe;
    }

}
