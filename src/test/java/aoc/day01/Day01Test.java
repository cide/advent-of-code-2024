package aoc.day01;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day01Test {

    @Test
    public void testPart1(){
        // Given
        final String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;

        // When
        final String result = new Day01().part1(input);

        final String expected = "11";
        // Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPart2(){
        // Given
        final String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;
        // When
        final String result = new Day01().part2(input);

        final String expected = "31";
        // Then
        Assertions.assertEquals(expected, result);
    }
}
