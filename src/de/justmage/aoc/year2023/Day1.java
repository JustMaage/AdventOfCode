package de.justmage.aoc.year2023;

import de.justmage.aoc.AdventDay;

public class Day1 extends AdventDay {

    public Day1() {
        super(2023, 1);
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println(day1.solution1());
        System.out.println(day1.solution2());
    }

    @Override
    public Object solution1() {
        int sum = 0;
        for (String line : lines) {
            int num1 = -1, num2 = -1;
            for (char c : line.toCharArray()) {
                if(Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    if(num1 == -1) {
                        num1 = digit;
                    } else {
                        num2 = digit;
                    }
                }
            }
            if(num2 == -1) {
                num2 = num1;
            }
            sum += Integer.parseInt(num1 + "" + num2);
        }
        return sum;
    }

    @Override
    public Object solution2() {
        int sum = 0;
        return sum;
    }
}
