package de.justmage.aoc.year2024;

import de.justmage.aoc.AdventDay;

import java.util.ArrayList;
import java.util.List;

public class Day2 extends AdventDay {

    public Day2() {
        super(2024, 2);
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        System.out.println(day2.solution1());
        System.out.println(day2.solution2());
    }

    @Override
    public Object solution1() {
        int safeReports = 0;
        for (String line : lines) {
            if(isSafe(line))
                safeReports++;
        }
        return safeReports;
    }

    private boolean isSafe(String report) {
        String[] numbers = report.split(" ");
        int previous = -1;
        int result = 0;
        boolean first = true;
        for (String number : numbers) {
            int current = Integer.parseInt(number);
            if(previous == -1) {
                previous = current;
                continue;
            }
            if(first) {
                result = previous - current;
                first = false;
            }
            if(result < 0) {
                // increasing
                if(previous - current > 0 || isUnsafeChange(Math.abs(previous - current))) {
                    return false;
                }
            } else {
                // decreasing
                if(previous - current < 0 || isUnsafeChange(Math.abs(previous - current))) {
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }

    private boolean isUnsafeChange(int amount) {
        return amount < 1 || amount > 3;
    }

    @Override
    public Object solution2() {
        int safeReports = 0;
        for (String line : lines) {
            if(isSafeWithOneRemoval(line))
                safeReports++;
        }
        return safeReports;
    }

    private boolean isSafeWithOneRemoval(String report) {
        if (isSafe(report)) {
            return true;
        }

        String[] numbers = report.split(" ");
        List<Integer> levels = new ArrayList<>();
        for (String num : numbers) {
            levels.add(Integer.parseInt(num));
        }

        // Try removing each level one by one and check if the report becomes safe
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> modifiedLevels = new ArrayList<>(levels);
            modifiedLevels.remove(i);
            if (isListSafe(modifiedLevels)) {
                return true;
            }
        }

        return false;
    }

    private boolean isListSafe(List<Integer> levels) {
        if (levels.size() < 2) {
            return true;
        }

        int initialDiff = levels.get(1) - levels.get(0);
        if (initialDiff == 0 || Math.abs(initialDiff) > 3) {
            return false;
        }

        boolean increasing = initialDiff > 0;

        for (int i = 1; i < levels.size(); i++) {
            int diff = levels.get(i) - levels.get(i - 1);
            if (diff == 0 || Math.abs(diff) > 3) {
                return false;
            }
            if (increasing && diff < 0) {
                return false;
            }
            if (!increasing && diff > 0) {
                return false;
            }
        }

        return true;
    }
}
