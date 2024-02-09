import greenfoot.*;

/**
 * De grot waarin alles gebeurt. De speler moet uit de grot 
 * ontsnappen door de deur te bereiken. Elk niveau toont een andere grot.
 */
public class Grot extends World {
    
    private int niveau;

    /**
     * Maak een grot aan voor het gegeven niveau en met de gegeven indeling
     */
    private Grot(int niveau, String[] indeling)
    {
        super(indeling[0].length(), indeling.length, 32);
        this.niveau = niveau;
        Greenfoot.setSpeed(30);
        /* vult de grot aan volgens de opgegeven indeling:*/
        for (int rij = 0; rij < indeling.length; rij++) {
            for (int kolom = 0; kolom < indeling[rij].length(); kolom ++) {
                char code = indeling[rij].charAt(kolom);
                if (code == '0') {
                    addObject( new Muur(), kolom, rij);
                }
                else if (code == 'x') {
                    addObject( new Blok(), kolom, rij);
                }
                else if (code == 'e') {
                    addObject( new Deur(), kolom, rij);
                }
                else if (code == '<') {
                    addObject( new Speler(-1), kolom, rij);
                }
                else if (code == '>') {
                    addObject( new Speler(+1), kolom, rij);
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
}
