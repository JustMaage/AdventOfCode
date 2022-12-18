package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

import java.io.FileNotFoundException;
import java.util.*;

public class Day1 extends AdventDay {

    public Day1() {
        super(2022, 1);
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println(day1.solution1());
        System.out.println(day1.solution2());
    }

    @Override
    public Object solution1() {
        List<Integer> calories = new ArrayList<>(Collections.singletonList(0));
        int index = 0;
        for (String line : lines) {
            if(line.equals("")) {
                calories.add(0);
                index++;
            } else {
                int current = calories.get(index);
                calories.set(index, current + Integer.parseInt(line));
            }
        }
        calories.sort(Comparator.reverseOrder());
        return calories.get(0);
    }

    @Override
    public Object solution2() {
        List<Integer> calories = new ArrayList<>(Collections.singletonList(0));
        int index = 0;
        for (String line : lines) {
            if(line.equals("")) {
                calories.add(0);
                index++;
            } else {
                int current = calories.get(index);
                calories.set(index, current + Integer.parseInt(line));
            }
        }
        calories.sort(Comparator.reverseOrder());
        return calories.get(0) + calories.get(1) + calories.get(2);
    }

}
