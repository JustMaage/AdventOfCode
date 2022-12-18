package de.justmage.aoc.year2022;

import de.justmage.aoc.AdventDay;

import java.util.HashMap;

public class Day7 extends AdventDay {

    public Day7() {
        super(2022, 7);
    }

    public static void main(String[] args) {
        Day7 day7 = new Day7();
        System.out.println(day7.solution1());
        System.out.println(day7.solution2());
    }

    @Override
    public Object solution1() {
        return null;
    }

    @Override
    public Object solution2() {
        return null;
    }
}

class Tree {
    private Node startingNode;

    public Tree(Node startingNode) {
        this.startingNode = startingNode;
    }
}

class Node {

    private HashMap<String, Double> directories = new HashMap<>();
    private HashMap<String, Double> files = new HashMap<>();

    public HashMap<String, Double> getDirectories() {
        return directories;
    }

    public void setDirectories(HashMap<String, Double> directories) {
        this.directories = directories;
    }

    public HashMap<String, Double> getFiles() {
        return files;
    }

    public void setFiles(HashMap<String, Double> files) {
        this.files = files;
    }
}