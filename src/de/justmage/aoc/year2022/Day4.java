package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

public class Day4 extends AdventDay {

    public Day4() {
        super(2022, 4);
    }

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        System.out.println(day4.solution1());
        System.out.println(day4.solution2());
    }

    @Override
    public Object solution1() {
        int count = 0;
        for (String line : lines) {
            String[] split = line.split(",");
            String elf1 = split[0];
            String elf2 = split[1];
            int[] nums1 = getNums(elf1);
            int[] nums2 = getNums(elf2);
            if((nums1[0] <= nums2[0] && nums1[1] >= nums2[1]) || (nums2[0] <= nums1[0] && nums2[1] >= nums1[1])) {
                count++;
            }
        }
        return count;
    }

    private int[] getNums(String elf1) {
        int[] nums = new int[2];
        String[] split = elf1.split("-");
        nums[0] = Integer.parseInt(split[0]);
        nums[1] = Integer.parseInt(split[1]);
        return nums;
    }

    @Override
    public Object solution2() {
        int count = 0;
        for (String line : lines) {
            String[] split = line.split(",");
            String elf1 = split[0];
            String elf2 = split[1];
            int[] nums1 = getNums(elf1);
            int[] nums2 = getNums(elf2);
            int first = nums1[0], second = nums1[1], third = nums2[0], fourth = nums2[1];
            if (first <= third && third <= second
                    || first <= fourth && fourth <= second
                    || third <= first && first <= fourth
                    || third <= second && second <= fourth){
                count++;
            }
        }
        return count;
    }
}
