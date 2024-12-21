package aoc.day04;

import java.util.List;

import aoc.Day;
import aoc.Utils;

public class Day04 implements Day {

    @Override
    public String part1(final String input) {
        final char[][] matrix = this.getCharMatrix(Utils.splitLines(input));
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                count += this.getWordCount(matrix, row, col, "XMAS");
            }
        }
        return String.valueOf(count);
    }

    @Override
    public String part2(final String input) {
        final char[][] matrix = this.getCharMatrix(Utils.splitLines(input));
        int count = 0;
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {
                count += this.isXmas(matrix, row, col) ? 1 : 0;
            }
        }
        return String.valueOf(count);
    }

    private int getWordCount(final char[][] matrix, final int startRow, final int startCol, final String word) {
        final int[][] directions = {
                { 0, 1 },
                { 1, 1 },
                { 1, 0 },
                { 1, -1 },
                { 0, -1 },
                { -1, -1 },
                { -1, 0 },
                { -1, 1 } };
        final int maxRows = matrix.length;
        final int maxCols = matrix[0].length;
        int count = 0;
        if (matrix[startRow][startCol] == word.charAt(0)) {
            for (final int[] direction : directions) {
                int row = startRow;
                int col = startCol;
                for (int pos = 1; pos < word.length(); pos++) {
                    row += direction[0];
                    col += direction[1];
                    if (row < 0 || row >= maxRows || col < 0 || col >= maxCols
                            || matrix[row][col] != word.charAt(pos)) {
                        break;
                    } else if (pos == word.length() - 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isXmas(final char[][] matrix, final int row, final int col) {
        final String forward = "MAS";
        final String backward = new StringBuilder(forward).reverse().toString();
        if (matrix[row][col] == forward.charAt(1)) {
            final char[] word1 = { matrix[row - 1][col - 1], matrix[row][col], matrix[row + 1][col + 1] };
            final char[] word2 = { matrix[row + 1][col - 1], matrix[row][col], matrix[row - 1][col + 1] };
            final boolean word1Match = forward.equals(String.valueOf(word1)) || backward.equals(String.valueOf(word1));
            final boolean word2Match = forward.equals(String.valueOf(word2)) || backward.equals(String.valueOf(word2));
            return word1Match && word2Match;
        } else {
            return false;
        }
    }

    private char[][] getCharMatrix(final List<String> lines) {
        final char[][] matrix = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i).toCharArray();
        }
        return matrix;
    }

}
