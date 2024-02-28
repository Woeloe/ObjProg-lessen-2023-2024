package be.ugent.objprog.langste;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Zoekt het langste woord in het Nederlands.
 * Deze versie haalt de woordenlijst uit een bestand. (Hier: /tmp/basiswoorden-gekeurd.txt)
 */
public class LangsteWoord3 {

    public String langste() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("/", "tmp", "basiswoorden-gekeurd.txt"))) {
            String line = reader.readLine();
            String langste = line;
            line = reader.readLine();
            while (line != null) {
                if (!line.contains(" ") && line.length() >= langste.length()) {
                    langste = line;
                }
                line = reader.readLine();
            }
            return langste;
        } catch (IOException ex) {
            throw new RuntimeException("Kon de woordenlijst niet laden", ex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LangsteWoord3().langste());
    }
}
