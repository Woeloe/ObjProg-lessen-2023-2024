package be.ugent.objprog.langste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Zoekt het langste woord in het Nederlands.
 * Deze versie haalt de woordenlijst uit het class path. (In package be.ugent.objprog.langste.)
 */
public class LangsteWoord2 {

    public String langste() {
        try (InputStream in = LangsteWoord2.class.getResourceAsStream("basiswoorden-gekeurd.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
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
        System.out.println(new LangsteWoord2().langste());
    }
}
