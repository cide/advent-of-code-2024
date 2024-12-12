package aoc.day01;

import aoc.Day;
import aoc.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class Day01 implements Day {

    @Override
    public String part1(String input) {
        List<String> lines = Utils.splitLines(input);
        List<Integer> leftIntegers = lines.stream().filter(s -> s.contains("  "))
                .map(s -> Integer.valueOf(s.split("   ")[0])).sorted()
                .collect(Collectors.toList());

        List<Integer> rightIntegers = lines.stream().filter(s -> s.contains("  "))
                .map(s -> Integer.valueOf(s.split("   ")[1])).sorted()
                .collect(Collectors.toList());
        int distance = 0;
        for(int i=0;i<leftIntegers.size();i++){
            distance += Math.abs(leftIntegers.get(i)-rightIntegers.get(i));
        }
        return String.valueOf(distance);
    }

    @Override
    public String part2(String input) {
        return input;
    }

}
