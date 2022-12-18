package de.justmage.aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AdventDay {

    protected final int year, dayOfMonth;
    protected final List<String> lines;

    public AdventDay(int year, int dayOfMonth) {
        this.year = year;
        this.dayOfMonth = dayOfMonth;
        lines = getLines(getInputFile());
    }

    protected File getInputFile() {
        return new File("src/de/justmage/aoc/year" + year + "/Day" + dayOfMonth + ".txt");
    }

    protected List<String> getLines(File file) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reader.lines().collect(Collectors.toList());
    }

    public abstract Object solution1();
    public abstract Object solution2();
}
