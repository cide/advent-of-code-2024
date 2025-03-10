package aoc.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day07Test {
    private final String input = """
            190: 10 19
            3267: 81 40 27
            83: 17 5
            156: 15 6
            7290: 6 8 6 15
            161011: 16 10 13
            192: 17 8 14
            21037: 9 7 18 13
            292: 11 6 16 20
                        """;

    @Test
    public void testPart1() {
        final String result = new Day07().part1(this.input);
        final String expected = "3749";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2() {
        final String result = new Day07().part2(this.input);
        final String expected = "6";
        Assertions.assertEquals(expected, result);
    }
}
