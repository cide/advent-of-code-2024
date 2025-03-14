package aoc.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day05Test {
    private final String input = """
            47|53
            97|13
            97|61
            97|47
            75|29
            61|13
            75|53
            29|13
            97|29
            53|29
            61|53
            97|53
            61|29
            47|13
            75|47
            97|75
            47|61
            75|61
            47|29
            75|13
            53|13

            75,47,61,53,29
            97,61,53,29,13
            75,29,13
            75,97,47,61,53
            61,13,29
            97,13,75,29,47
                                        """;

    @Test
    public void testPart1() {
        final String result = new Day05().part1(this.input);
        final String expected = "143";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2() {
        final String result = new Day05().part2(this.input);
        final String expected = "123";
        Assertions.assertEquals(expected, result);
    }
}
