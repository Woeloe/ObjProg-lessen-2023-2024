package be.ugent.objprog.langste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * Zoekt het langste woord in het Nederlands.
 * Deze versie haalt de woordenlijst uit een bestand. (Hier: /tmp/basiswoorden-gekeurd.txt)
 */
public class LangsteWoord4 {

    public String langste() {
        try {
            return Files.lines(Path.of("/", "tmp", "basiswoorden-gekeurd.txt"))
                    .filter(s -> !s.contains(" "))
                    .max(Comparator.comparing(String::length)).orElseThrow();
        } catch (IOException ex) {
            throw new RuntimeException("Kon de woordenlijst niet laden", ex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LangsteWoord4().langste());
    }
}
