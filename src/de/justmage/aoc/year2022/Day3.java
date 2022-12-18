package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day3 extends AdventDay {

    public Day3() {
        super(2022, 3);
    }

    public static void main(String[] args) {
        Day3 day3 = new Day3();
        System.out.println(day3.solution1());
        System.out.println(day3.solution2());
    }

    private final String types = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public Object solution1() {
        // find common type, get type priority, return the sum
        int sum = 0;
        for (String line : lines) {
            String firstHalf = line.substring(0, line.length() / 2);
            String secondHalf = line.replaceAll(firstHalf, "");
            String commonType = getCommonType(firstHalf, secondHalf);
            int priority = types.indexOf(commonType) + 1;
            sum += priority;
        }
        return sum;
    }

    private String getCommonType(String firstHalf, String secondHalf) {
        for (char c : secondHalf.toCharArray()) {
            if(firstHalf.contains(c + ""))
                return c + "";
        }
        return null;
    }

    @Override
    public Object solution2() {
        int sum = 0;
        for (int i = 0; i < lines.size() - 2; i += 3) {
            String elf1 = lines.get(i);
            String elf2 = lines.get(i + 1);
            String elf3 = lines.get(i + 2);
            String commonType = getCommonType(elf1, elf2, elf3);
            int priority = types.indexOf(commonType) + 1;
            sum += priority;
        }
        return sum;
    }

    // fucking ugly but working
    private String getCommonType(String elf1, String elf2, String elf3) {
        HashMap<Character, Integer> letterMap = new HashMap<>();
        for (char c : removeDoubleLetters(elf1).toCharArray()) {
            if(letterMap.containsKey(c)) {
                int count = letterMap.get(c);
                letterMap.put(c, count + 1);
            } else {
                letterMap.put(c, 1);
            }
        }
        for (char c : removeDoubleLetters(elf2).toCharArray()) {
            if(letterMap.containsKey(c)) {
                int count = letterMap.get(c);
                letterMap.put(c, count + 1);
            } else {
                letterMap.put(c, 1);
            }
        }
        for (char c : removeDoubleLetters(elf3).toCharArray()) {
            if(letterMap.containsKey(c)) {
                int count = letterMap.get(c);
                letterMap.put(c, count + 1);
            } else {
                letterMap.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : letterMap.entrySet()) {
            if(entry.getValue() > 2)
                return entry.getKey() + "";
        }
        return null;
    }

    private String removeDoubleLetters(String toRemove) {
        StringBuilder letters = new StringBuilder();
        for (char c : toRemove.toCharArray()) {
            if(!letters.toString().contains(c + ""))
                letters.append(c);
        }
        return letters.toString();
    }
}
