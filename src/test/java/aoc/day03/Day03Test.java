package aoc.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day03Test {

    private final String input = """
           xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
                            """;

    @Test
    public void testPart1() {
        final String result = new Day03().part1(this.input);
        final String expected = "161";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2() {
        final String result = new Day03().part2(this.input);
        final String expected = "48";
        Assertions.assertEquals(expected, result);
    }
}
