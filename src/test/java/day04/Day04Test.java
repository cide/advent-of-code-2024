package day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aoc.day04.Day04;

public class Day04Test {
    private final String input = """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
                                        """;

    @Test
    public void testPart1() {
        final String result = new Day04().part1(this.input);
        final String expected = "18";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2() {
        final String result = new Day04().part2(this.input);
        final String expected = "9";
        Assertions.assertEquals(expected, result);
    }
}
