package aoc.day06;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import aoc.Day;
import aoc.Utils;

public class Day06 implements Day {

    private final Character up = '^';
    private final Character right = '>';
    private final Character down = 'v';
    private final Character left = '<';
    private final Map<Character, Coord> guardDirections = Map.of(this.up, new Coord(0, -1), this.right, new Coord(1, 0), this.down,
            new Coord(0, 1), this.left, new Coord(-1, 0));
    private final Map<Character, Character> newDirections = Map.of(this.up, this.right, this.right, this.down, this.down, this.left, this.left, this.up);
    private final Character barrier = '#';
    private final Character visited = 'X';

    @Override
    public String part1(final String input) {
        final char[][] patrolArea = Utils.getCharMatrix(input);

        Coord position = this.findGuard(patrolArea);

        while (position != null && this.isInPatrolArea(patrolArea, position)) {
            position = this.moveGuard(patrolArea, position);
        }
        int count = Stream.of(patrolArea).flatMap(row -> CharBuffer.wrap(row).chars().mapToObj(c -> (char) c)).filter(c -> visited.equals(c)).toList().size();
        return String.valueOf(count);
    }

    @Override
    public String part2(final String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'part2'");
    }

    private Coord findGuard(final char[][] patrolArea) {
        for (int x = 0; x < patrolArea[0].length; x++) {
            for (int y = 0; y < patrolArea.length; y++) {
                if (this.guardDirections.keySet().contains(patrolArea[y][x])) {
                    return new Coord(x, y);
                }
            }
        }
        return null;
    }

    private boolean isInPatrolArea(final char[][] patrolArea, final Coord pos) {
        return pos.x >= 0 && pos.x < patrolArea[0].length && pos.y >= 0 && pos.y < patrolArea.length;
    }

    private Coord moveGuard(final char[][] patrolArea, final Coord pos) {
        Character guard = patrolArea[pos.y][pos.x];
        if (this.guardDirections.containsKey(guard)) {
            final Coord initialDirection = this.guardDirections.get(guard);
            Coord direction = initialDirection;
            Coord nextPos = pos.add(direction);
            while (this.isInPatrolArea(patrolArea, nextPos) && this.barrier.equals(patrolArea[nextPos.y][nextPos.x])) {
                guard = this.newDirections.get(guard);
                direction = this.guardDirections.get(guard);
                nextPos = pos.add(direction);
                if (initialDirection.equals(direction)) {
                    return null;
                }
            }
            patrolArea[pos.y][pos.x] = this.visited;
            if (this.isInPatrolArea(patrolArea, nextPos)) {
                patrolArea[nextPos.y][nextPos.x] = guard;
            }
            return nextPos;
        }
        return null;
    }

    class Coord {
        int x;
        int y;

        Coord(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public Coord add(final Coord direction) {
            return new Coord(this.x + direction.x, this.y + direction.y);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + this.x;
            result = prime * result + this.y;
            return result;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (this.getClass() != obj.getClass())
                return false;
            final Coord other = (Coord) obj;
            if (this.x != other.x)
                return false;
            if (this.y != other.y)
                return false;
            return true;
        }

    }
}