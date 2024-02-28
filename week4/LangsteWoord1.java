package be.ugent.objprog.langste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Zoekt het langste woord in het Nederlands.
 * Deze versie haalt de woordenlijst van het Internet
 */
public class LangsteWoord1 {

    public String langste() throws MalformedURLException {
        URL url = new URL("https://raw.githubusercontent.com/OpenTaal/opentaal-wordlist/master/elements/basiswoorden-gekeurd.txt");
        try (InputStream in = url.openStream();
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

    public static void main(String[] args) throws MalformedURLException {
        System.out.println(new LangsteWoord1().langste());
    }
}
