package aoc.day01;

import java.util.List;

import aoc.Day;
import aoc.Utils;

public class Day01 implements Day {

    @Override
    public String part1(final String input) {
        final List<String> lines = Utils.splitLines(input);
        final List<Integer> leftIntegers = lines.stream().filter(s -> s.contains("  "))
                .map(s -> Integer.valueOf(Utils.splitColumns(s)[0])).sorted()
                .toList();

        final List<Integer> rightIntegers = lines.stream().filter(s -> s.contains("  "))
                .map(s -> Integer.valueOf(Utils.splitColumns(s)[1])).sorted()
                .toList();
        int distance = 0;
        for(int i=0;i<leftIntegers.size();i++){
            distance += Math.abs(leftIntegers.get(i)-rightIntegers.get(i));
        }
        return String.valueOf(distance);
    }

    @Override
    public String part2(final String input) {
        final List<String> lines = Utils.splitLines(input);
        
        return input;
    }


}
