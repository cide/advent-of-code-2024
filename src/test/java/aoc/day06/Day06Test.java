package aoc.day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day06Test {
    private final String input = """
            ....#.....
            .........#
            ..........
            ..#.......
            .......#..
            ..........
            .#..^.....
            ........#.
            #.........
            ......#...
            """;

    @Test
    public void testPart1() {
        final String result = new Day06().part1(this.input);
        final String expected = "41";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2() {
        final String result = new Day06().part2(this.input);
        final String expected = "6";
        Assertions.assertEquals(expected, result);
    }
}
