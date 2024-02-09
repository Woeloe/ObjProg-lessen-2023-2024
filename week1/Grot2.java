import greenfoot.*;
import java.util.Map;

/**
 * De grot waarin alles gebeurt. De speler moet uit de grot 
 * ontsnappen door de deur te bereiken. Elk niveau toont een andere grot.
 */

public class Grot extends World {

    // Binneninterfaces zijn automatisch statisch, ook al schrijf je dit
    // er niet expliciet bij
    //
    // Implementaties van Generator staan helemaal onderaan deze klasse
    private interface Generator {
        void createAt (int kolom, int rij);
    }

    private int niveau;

    // Merk op dat dit nu niet langer een klassenvariabele kan zijn, omdat
    // we anders geen niet-statische binnenklassen kunnen hebben.
    // Ook met statische binnenklassen zou dit niet meer lukken, omdat
    // ze hoe dan ook toegang moeten krijgen tot het grot-object
    //
    private final Map<Character,Generator> generators;

    /**
     * Maak een grot aan voor het gegeven niveau en met de gegeven indeling
     */
    private Grot(int niveau, String[] indeling)
    {
        super(indeling[0].length(), indeling.length, 32);
        this.niveau = niveau;
        Greenfoot.setSpeed(30);

        this.generators = Map.of (
            '0', new MuurGenerator (),
            'x', new BlokGenerator (),
            'e', new DeurGenerator (),
            '<', new SpelerGenerator(-1),
            '>', new SpelerGenerator(+1)        
        );

        /* vult de grot aan volgens de opgegeven indeling:*/
        for (int rij = 0; rij < indeling.length; rij++) {
            for (int kolom = 0; kolom < indeling[rij].length(); kolom ++) {
                char code = indeling[rij].charAt(kolom);
                Generator generator = generators.get(code);
                if (generator != null) {
                    generator.createAt(kolom, rij);
                }
            }
        }
        /* plaats de Info-teksten:*/
        addObject( new Info("Niveau:" + niveau), 2, 1);
        addObject( new Info("Herstart"), getWidth() - 3, 1);
    }

    /**
     * Maakt een grot aan voor het opgegeven niveau. Haalt de beschrijving van de grot uit de klasse Indelingen.
     */
    public Grot(int niveau)
    {
        this(niveau, Indelingen.get(niveau));
    }

    /**
     * Maakt een grot aan voor niveau 0. Dit is de grot die wordt getoond bij het opstarten.
     */
    public Grot()
    {
        this(0);
    }

    /**
     * Vervang deze grot door een grot van het volgende niveau - of door de begingrot wanneer alle niveaus zijn uitgespeeld
     */
    public void volgendNiveau()
    {
        niveau = niveau + 1;
        if (niveau == Indelingen.size()) {
            niveau = 0;
        }
        Greenfoot.setWorld( new Grot(niveau));
    }

    /**
     * Herstart het huidige niveau door een nieuwe grot aan te maken met dezelfde indeling als de huidige grot
     */
    public void herstartNiveau()
    {
        Greenfoot.setWorld( new Grot(niveau));
    }

    /* Opmerking
     * 
     * Al deze binnenklassen zijn niet-statisch, omdat we de methode
     * addWorld van deze grot gemakkelijk willen kunnen gebruiken
     */

    private class MuurGenerator implements Generator {
        public void createAt (int kolom, int rij) {
            addObject (new Muur(), kolom, rij);
        }
    }

    private class DeurGenerator implements Generator {
        public void createAt (int kolom, int rij) {
            addObject (new Deur(), kolom, rij);
        }
    }

    private class BlokGenerator implements Generator {
        public void createAt (int kolom, int rij) {
            addObject (new Blok(), kolom, rij);
        }
    }

    private class SpelerGenerator implements Generator {

        private final int richting;

        public SpelerGenerator(int richting) {
            this.richting = richting;
        }

        public void createAt (int kolom, int rij) {
            addObject (new Speler(richting), kolom, rij);
        }
    }

}
