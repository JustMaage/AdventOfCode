package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

public class Day2 extends AdventDay {

    // A/X -> Rock, B/Y -> Paper, C/Z -> Scissors
    public Day2() {
        super(2022, 2);
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        System.out.println(day2.solution1());
        System.out.println(day2.solution2());
    }

    @Override
    public Object solution1() {
        int totalPoints = 0;
        for (String line : lines) {
            String[] split = line.split(" ");
            Move opponent = getMovePlayed(split[0]);
            Move own = getMovePlayed(split[1]);
            totalPoints += getPoints(opponent, own);
        }
        return totalPoints;
    }

    private int getPoints(Move opponent, Move own) {
        int points = own.value;
        if(opponent == own) {
            points += 3;
        } else if((opponent == Move.Rock && own == Move.Paper)
                || (opponent == Move.Paper && own == Move.Scissors)
                || (opponent == Move.Scissors && own == Move.Rock)) {
            points += 6;
        }
        return points;
    }

    @Override
    public Object solution2() {
        int totalPoints = 0;
        for (String line : lines) {
            String[] split = line.split(" ");
            Move opponent = getMovePlayed(split[0]);
            Move own = getMoveFromStrategy(opponent, split[1]);
            totalPoints += getPoints(opponent, own);
        }
        return totalPoints;
    }

    private Move getMoveFromStrategy(Move opponent, String move) {
        if(move.equals("X")) { // lose
            if(opponent == Move.Rock) {
                return Move.Scissors;
            } else if(opponent == Move.Paper) {
                return Move.Rock;
            } else {
                return Move.Paper;
            }
        } else if(move.equals("Y")) { // draw
            return opponent;
        } else { // win
            if(opponent == Move.Rock) {
                return Move.Paper;
            } else if(opponent == Move.Paper) {
                return Move.Scissors;
            } else {
                return Move.Rock;
            }
        }
    }

    private Move getMovePlayed(String input) {
        if(input.equals("A") || input.equals("X")) {
            return Move.Rock;
        } else if (input.equals("B") || input.equals("Y")) {
            return Move.Paper;
        } else {
            return Move.Scissors;
        }
    }
}

enum Move {
    Rock(1),
    Paper(2),
    Scissors(3);

    public final int value;

    Move(int value) {
        this.value = value;
    }
}