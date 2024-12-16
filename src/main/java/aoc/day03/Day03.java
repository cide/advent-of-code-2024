package aoc.day03;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import aoc.Day;

public class Day03 implements Day {
    private final Pattern multPattern = Pattern.compile("mul\\([\\d]{1,3},[\\d]{1,3}\\)");
    private final Pattern instPattern = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\([\\d]{1,3},[\\d]{1,3}\\)");

    @Override
    public String part1(final String input) {
        int result = 0;
        try (Scanner multScanner = new Scanner(input)) {
            final boolean work = true;
            for (final MatchResult match : multScanner.findAll(this.multPattern).toList()) {
                result += this.calc(match.group());
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String part2(final String input) {
        int result = 0;
        try (Scanner multScanner = new Scanner(input)) {
            boolean work = true;
            for (final MatchResult match : multScanner.findAll(this.instPattern).toList()) {
                final String instruction = match.group();
                switch (instruction) {
                    case "do()":
                        work = true;
                        break;
                    case "don't()":
                        work = false;
                        break;
                    default:
                        if (work) {
                            result += this.calc(instruction);
                        }
                }
            }
        }
        return String.valueOf(result);
    }

    private int calc(final String instruction) {
        final String[] instParts = instruction.split("[\\(,\\)]");
        if (instParts.length == 3) {
            return switch (instParts[0]) {
                case "mul" -> Integer.valueOf(instParts[1]) * Integer.valueOf(instParts[2]);
                default -> 0;
            };
        }
        return 0;
    }

}
