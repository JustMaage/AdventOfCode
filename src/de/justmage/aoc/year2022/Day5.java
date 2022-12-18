package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day5 extends AdventDay {

    public Day5() {
        super(2022, 5);
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        System.out.println(day5.solution1());
        System.out.println(day5.solution2());
    }

    @Override
    public Object solution1() {
        String[] stacks = getStacks();
        for (String s : getInput()) {
            String[] split = s.split(" ");
            int amount = Integer.parseInt(split[1]);
            int from = Integer.parseInt(split[3]) - 1;
            int to = Integer.parseInt(split[5]) - 1;
            String fromStack = stacks[from];
            String toStack = stacks[to];
            for (int i = 0; i < amount; i++) {
                String letter = fromStack.substring(fromStack.length() - 1);
                toStack += letter;
                fromStack = fromStack.substring(0, fromStack.length() - 1);
            }
            stacks[to] = toStack;
            stacks[from] = fromStack;
        }
        String result = "";
        for (String stack : stacks) {
            result += stack.substring(stack.length() - 1);
        }
        return result;
    }

    @Override
    public Object solution2() {
        String[] stacks = getStacks();
        for (String s : getInput()) {
            String[] split = s.split(" ");
            int amount = Integer.parseInt(split[1]);
            int from = Integer.parseInt(split[3]) - 1;
            int to = Integer.parseInt(split[5]) - 1;
            String fromStack = stacks[from];
            String toStack = stacks[to];

            String letter = fromStack.substring(fromStack.length() - amount);
            toStack += letter;
            fromStack = fromStack.substring(0, fromStack.length() - amount);

            stacks[to] = toStack;
            stacks[from] = fromStack;
        }
        String result = "";
        for (String stack : stacks) {
            result += stack.substring(stack.length() - 1);
        }
        return result;
    }

    private List<String> getInput() {
        List<String> input = new ArrayList<>();
        for (int i = 10; i < lines.size(); i++) {
            input.add(lines.get(i));
        }
        return input;
    }

    private String[] getStacks() {
        int numStacks = Integer.parseInt(String.valueOf(lines.get(8).charAt(lines.get(8).length() - 1)));
        String[] stacks = new String[numStacks];
        Arrays.fill(stacks, "");
        for (int j = 7; j >= 0; j--) {
            for (int i = 0; i < stacks.length; i++) {
                if(lines.get(j).charAt(4 * i + 1) != ' ') {
                    stacks[i] += lines.get(j).charAt(4 * i + 1);
                }
            }
        }
        return stacks;
    }
}