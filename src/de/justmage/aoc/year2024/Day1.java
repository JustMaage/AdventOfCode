package de.justmage.aoc.year2024;

import de.justmage.aoc.AdventDay;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day1 extends AdventDay {

    public Day1() {
        super(2024, 1);
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println(day1.solution1());
        System.out.println(day1.solution2());
    }

    @Override
    public Object solution1() {
        List<int[]> parsedInput = parseInput();
        validateInput(parsedInput);

        List<Integer> firstList = parsedInput.stream()
                .map(pair -> pair[0])
                .sorted()
                .collect(Collectors.toList());

        List<Integer> secondList = parsedInput.stream()
                .map(pair -> pair[1])
                .sorted()
                .collect(Collectors.toList());

        return IntStream.range(0, firstList.size())
                .map(i -> Math.abs(firstList.get(i) - secondList.get(i)))
                .sum();
    }

    @Override
    public Object solution2() {
        List<int[]> parsedInput = parseInput();
        validateInput(parsedInput);

        List<Integer> firstList = parsedInput.stream()
                .map(pair -> pair[0])
                .sorted()
                .collect(Collectors.toList());

        List<Integer> secondList = parsedInput.stream()
                .map(pair -> pair[1])
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, Long> frequencyMap = secondList.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return firstList.stream()
                .mapToInt(x -> x * frequencyMap.getOrDefault(x, 0L).intValue())
                .sum();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<int[]> parseInput() {
        List<int[]> parsedLines = new ArrayList<>();
        for (String line : lines) {
            String[] numbers = line.split(" {3}");
            if (numbers.length != 2 || !isNumeric(numbers[0]) || !isNumeric(numbers[1]))
                throw new InputMismatchException("Input did not contain two numbers as expected");
            parsedLines.add(new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1])});
        }
        return parsedLines;
    }

    private void validateInput(List<int[]> parsedInput) {
        if (parsedInput.isEmpty())
            throw new IllegalArgumentException("Input cannot be empty");
        for (int[] pair : parsedInput) {
            if (pair.length != 2)
                throw new InputMismatchException("Each line must contain exactly two numbers");
        }
    }
}
