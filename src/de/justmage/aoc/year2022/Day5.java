package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 extends AdventDay {

    public Day5() {
        super(2022, 5);
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        System.out.println(day5.solution1());
        System.out.println(day5.solution2());
        day5.getStacks();
    }

    @Override
    public Object solution1() {
        return null;
    }

    @Override
    public Object solution2() {
        return null;
    }

    private List<String> getInput() {
        List<String> input = new ArrayList<>();
        for (int i = 10; i < lines.size(); i++) {
            input.add(lines.get(i));
        }
        return input;
    }

    private void getStacks() {

    }
}
