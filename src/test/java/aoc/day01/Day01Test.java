package aoc.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day01Test {

    private final static String input = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
            """;

    @Test
    public void testPart1() {
        final String result = new Day01().part1(input);
        final String expected = "11";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2() {
        final String result = new Day01().part2(input);
        final String expected = "31";
        Assertions.assertEquals(expected, result);
    }
}
