package be.ugent.objprog.cowboy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cowboy {

    private final List<List<String>> verses;

    private final int width;

    public Cowboy(int width) {
        this.verses = new ArrayList<>();
        this.width = width;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Cowboy.class.getResourceAsStream("cowboy.txt")
                ))) {
            for (int i = 0; i < 3; i++) {
                List<String> lines = new ArrayList<>();
                for (int j = 0; j < 9; j++) {
                    lines.add(reader.readLine());
                }
                verses.add(lines);
            }
        } catch (Exception ex) {
            throw new RuntimeException("'cowboy.txt' niet gevonden", ex);
        }
    }

    public void prettyPrint() {

        // Eerste manier
        ////////////////

        int pos = 0;
        for (Alignment alignment : Alignment.values()) {
            verses.get(pos).stream()
                    .map(line -> alignment.align(line, width))
                    .forEach(System.out::println);
            pos ++;
        }

        // Tweede manier
        ////////////////

        for (int i = 0; i < verses.size(); i++) {
            Alignment alignment = Alignment.values()[i];
                verses.get(i).stream()
                    .map(line -> alignment.align(line, width))
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        new Cowboy(60).prettyPrint();
    }
}
