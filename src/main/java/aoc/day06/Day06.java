package aoc.day06;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import aoc.Day;
import aoc.Utils;

public class Day06 implements Day {

    private final Character up = '^';
    private final Character right = '>';
    private final Character down = 'v';
    private final Character left = '<';
    private final Map<Character, Coord> guardDirections = Map.of(this.up, new Coord(0, -1), this.right, new Coord(1, 0),
            this.down,
            new Coord(0, 1), this.left, new Coord(-1, 0));
    private final Map<Character, Character> newDirections = Map.of(this.up, this.right, this.right, this.down,
            this.down, this.left, this.left, this.up);
    private final Character barrier = '#';
    private final Character visited = 'X';

    @Override
    public String part1(final String input) {
        final char[][] patrolArea = Utils.getCharMatrix(input);

        int count = 0;
        if (this.walkFromArea(patrolArea)) {
            count = Stream.of(patrolArea).flatMap(row -> CharBuffer.wrap(row).chars().mapToObj(c -> (char) c))
                    .filter(c -> this.visited.equals(c)).toList().size();
        }
        return String.valueOf(count);
    }

    @Override
    public String part2(final String input) {
        final char[][] patrolArea = Utils.getCharMatrix(input);
        int count = 0;
        final Coord startCoord = this.findGuard(patrolArea);
        if (this.walkFromArea(patrolArea)) {
            final List<Coord> visitedCoords = this.getCoordsWithChar(patrolArea, Set.of(this.visited)).stream().filter(p -> !p.equals(startCoord)).toList();
            for (final Coord block : visitedCoords) {
                final char[][] newPatrolArea = Utils.getCharMatrix(input);
                newPatrolArea[block.y][block.x] = this.barrier;
                if (!this.walkFromArea(newPatrolArea, true)) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }

    /**
     * Walks the guard until he leaves the area or it is running in a loop. Returns
     * {@link true} if guard left the area. Visited positions will be marked with
     * the {@link visitied} character.
     * 
     * @param patrolArea
     * @return
     */
    private boolean walkFromArea(final char[][] patrolArea) {
        return this.walkFromArea(patrolArea, false);
    }

    /**
     * Walks the guard until he leaves the area or it is running in a loop. Returns
     * {@link true} if guard left the area. If markDirections is true, visited
     * positions will be marked with the guard's character, otherwise with the
     * {@link visitied} character.
     * 
     * @param patrolArea
     * @return
     */
    private boolean walkFromArea(final char[][] patrolArea, final boolean markDirections) {
        Coord position = this.findGuard(patrolArea);
        while (position != null && this.isInPatrolArea(patrolArea, position)) {
            position = this.moveGuard(patrolArea, position, markDirections);
        }
        return position != null;
    }

    /**
     * Returns the (first found) {@link Coord} of the guard.
     * 
     * @param patrolArea
     * @return
     */
    private Coord findGuard(final char[][] patrolArea) {
        final List<Coord> foundCoords = this.getCoordsWithChar(patrolArea, this.guardDirections.keySet());
        if (!foundCoords.isEmpty()) {
            return foundCoords.get(0);
        }else{
            return null;
        }
    }

    /**
     * Checks if pos is inside of the patrolArea.
     * 
     * @param patrolArea
     * @param pos
     * @return
     */
    private boolean isInPatrolArea(final char[][] patrolArea, final Coord pos) {
        return pos.x >= 0 && pos.x < patrolArea[0].length && pos.y >= 0 && pos.y < patrolArea.length;
    }

    /**
     * Moves the guard at pos in the guards walking direction. If a barrier blocks
     * his way the guard will be try the next possible direction. Returns
     * {@link null} if the guard can't move or visits a postion in the same
     * direction twice and markDirections is {@link true}.
     * 
     * If markDirections is {@łink true}, the last position will be marked with the new
     * guard direction, otherwise with the {@link visited} character.
     * 
     * @param patrolArea
     * @param pos
     * @return next position or {@link null} (see above) 
     */
    private Coord moveGuard(final char[][] patrolArea, final Coord pos, final boolean markDirections) {
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
                    // guard is surrounded by barriers
                    return null;
                }
            }
            patrolArea[pos.y][pos.x] = markDirections ? guard : this.visited;
            if (this.isInPatrolArea(patrolArea, nextPos)) {
                if (markDirections && guard.equals(patrolArea[nextPos.y][nextPos.x])) {
                    // guard walks in a loop
                    return null;
                }
                patrolArea[nextPos.y][nextPos.x] = guard;
            }
            return nextPos;
        }
        return null;
    }

    private List<Coord> getCoordsWithChar(final char[][] patrolArea, final Set<Character> find) {
        final List<Coord> foundCoords = new ArrayList<>();
        for (int x = 0; x < patrolArea[0].length; x++) {
            for (int y = 0; y < patrolArea.length; y++) {
                if (find.contains(patrolArea[y][x])) {
                    foundCoords.add(new Coord(x, y));
                }
            }
        }
        return foundCoords;
    }

    class Coord {
        int x;
        int y;

        Coord(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Adds direction {@link Coord} to the current position and returns new
         * {@link Coord} object.
         * 
         * @param direction
         * @return
         */
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