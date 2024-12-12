package aoc.day01;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    @Test
    public void testPart1(){
        // Given
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;

        // When
        String result = new Day01().part1(input);

        String expected = "11";
        // Then
        assertEquals(expected, result);
    }

    @Test
    public void testPart2(){
        // Given
        String input = "test";

        // When
        String result = new Day01().part2(input);

        // Then
        assertEquals(input, result);
    }
}
