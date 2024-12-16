package aoc.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02Test {

    private String input = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
                            """;

    @Test
    public void testPart1() {
        final String result = new Day02().part1(input);
        final String expected = "2";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2() {
        final String result = new Day02().part2(input);
        final String expected = "4";
        Assertions.assertEquals(expected, result);
    }
}
