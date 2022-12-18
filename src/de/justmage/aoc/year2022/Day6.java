package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

public class Day6 extends AdventDay {

    public Day6() {
        super(2022, 6);
    }

    public static void main(String[] args) {
        Day6 day6 = new Day6();
        System.out.println(day6.solution1());
        System.out.println(day6.solution2());
    }

    @Override
    public Object solution1() {
        String input = lines.get(0);
        int repeating = 4;
        for (int i = 0; i < input.length() - repeating; i++) {
            String used = "";
            for(int j = 0; j < repeating; j++) {
                if(!used.contains(input.charAt(i + j) + "")) {
                    used += input.charAt(i + j);
                } else
                    break;
                if(used.length() == repeating)
                    return i + repeating;
            }
        }
        return "";
    }

    @Override
    public Object solution2() {
        String input = lines.get(0);
        int repeating = 14;
        for (int i = 0; i < input.length() - repeating; i++) {
            String used = "";
            for(int j = 0; j < repeating; j++) {
                if(!used.contains(input.charAt(i + j) + "")) {
                    used += input.charAt(i + j);
                } else
                    break;
                if(used.length() == repeating)
                    return i + repeating;
            }
        }
        return "";
    }
}
