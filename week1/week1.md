Objectgericht programmeren - week 1
===

*Tip.* Maak één IDEA-project aan voor alle oefeningen in plaats van een afzonderlijk
project per oefening. Gebruik packages (`week1`, `week2`, …) om je oefeningen uit elkaar te houden.

De cijfers en titels verwijzen naar de [cursusnota's](../javafx.pdf)

### 2.1-2.2 Programmeren zonder if  

**Oefening Display** Download [dit IDEA-project](display.zip?raw=true) en pak het uit. Open het mapje
`display` met IntelliJ IDEA.

Voer de klasse `Display` uit. Bij een druk op de knop loopt het zevensegmentendisplay achtereenvolgens door de cijfers 0, 1, 2 en 3.

Pas de methode `show` uit de klasse `SegmentButton` aan zodat er geen meervoudige selecties meer in voorkomen. Pas 
daarna het programma aan
zodat het *alle* cijfers van 0-9 achtereenvolgens afbeeldt. Je moet dan ook een kleine wijziging doen in 
de methode `handle`. Je mag aan de andere klassen en methoden niets veranderen. 

Zou het gemakkelijker geweest zijn om eerst 
die zes bijkomende cijfers te implementeren en pas daarna de meervoudige selectie weg te werken?

**Oefening Block Dude** Download [dit greenfoot-project](blockdude.zip?raw=true) en pak het uit<sup>1</sup>. 
(*Tip*: elk van de vier pijltjestoetsen heeft een ander effect.)

Merk op dat enkel
de klasse `Grot` in Java is genoteerd, voor de andere klassen werd *Stride* gebruikt. Maar dat geeft niet, want het is precies
die klasse waarover de opgave gaat. Je kan het al raden: als opgave moet je de meervoudige selectie uit deze klasse halen. 

Je moet hiervoor onvermijdelijk enkele
nieuwe klassen/interfaces aanmaken (let op dat je daarbij *Java* selecteert, en niet Stride) en dat lijkt nogal veel 
werk voor het luttele voordeel dat dit oplevert, maar we komen daar later op terug.

### 1.3-1.4 Binnenklassen

**Oefening Block Dude 2** (Baseer je op de oplossing van de eerdere oefening met dezelfde naam, of gebruik onze 
oplossing die je onderaan deze bladzijde terugvindt.)

De interface en de klassen die je hebt aangemaakt bij de eerste versie van deze oefening zouden gemakkelijk (statische) binnenklassen
kunnen worden. Omdat er geen uitdaging schuilt in het enkel knippen en plakken van Java-code, passen we de opgave lichtjes aan.

In de plaats van een gewone  *factory* waarmee enkel een nieuwe actor wordt aangemaakt,
moet je nu de volgende interface gebruiken:

    public interface Generator {
        void createAt (int kolom, int rij);
    }
De methode `createAt` maakt niet alleen een nieuwe actor aan, maar plaatst die meteen in de grot.

Plaats deze interface, en al zijn implementaties, binnen in `Grot`. Denk goed na of je hier een statische, dan wel een niet-statische
binnenklasse zult gebruiken.

#### Oplossingen

Enkel wanneer het je zelf na een half uur nog niet lukt… (half uur per oefening!)

* [Display](SegmentButton.java) - lees ook het commentaar onderaan de broncode
* [Block Dude](blockdude-opl.zip?raw=true) - nuttig om deze oplossing hoe dan ook eens te bekijken, ze is 
  misschien niet helemaal dezelfde als de jouwe. (Hoeveel nieuwe klassen heb jij aangemaakt?)
* De klasse `Grot` voor [Block Dude 2](Grot2.java)

#### Voetnoten

<sup>1</sup> We zouden geen BlueJ meer gebruiken, maar over Greenfoot hebben we niets gezegd :-) 
Wie greenfoot niet langer op zijn computer heeft staan en geen zin heeft om die opnieuw te [installeren](https://greenfoot.org/download)
kan deze [Grot.java](Grot0.java) aanpassen, maar helaas niet te weten komen of ze alle niveaus van Block Dude kunnen uitspelen…

Dit Greenfoot-project werd oorspronkelijk uitgewerkt door Nils Mak als opdracht voor de lerarenopleiding informatica. 
