Objectgericht programmeren - week 3
===

### 1.6 Java Streams

**Oefening Cowboy 2** Vertrek van de van oefening Cowboy van vorige week.
Vervang in `prettyPrint` telkens de binnenste lussen door een Java stream.

(Dit is maar een kleine oefening, maar ook in latere oefeningen
zullen af en toe nog streams opduiken.)

### 1.7 Klassen, interfaces en methodes met typeparameters

**Oefening Maximizer** Schrijf een (generieke) klasse `Maximizer` die één voor één
elementen aanneemt, en telkens de gelegenheid biedt om het grootste
element terug te geven dat tot dan toe is aangeboden. Je moet `Maximizer`
op de volgende manier kunnen gebruiken:

    Maximizer<Double> maximizer = new Maximizer<> (1.5); // eerste element
    maximizer.add (1.0);
    maximizer.add (3.0);
    maximizer.add (-0.2);
    System.out.println (maximizer.max()); // print 3.0

In dit voorbeeld gebruiken we kommagetallen, maar dit moet ook werken met gehele getallen
en met strings.

(Er treedt een kleine moeilijkheid op bij deze oefening waarbij de cursusnota's
je niet direct kunnen helpen. Krijg je waarschuwingen zoals '*Raw use of parametrized class*'
en/of '*Unchecked call to …*', bekijk dan [deze tip](maximizer-tip.md).)

**Oefening Maximizer 2** Schrijf een generieke (klassen)*methode* max die
het maximum van een lijst van dingen kan bepalen. Je moet dezelfde methode kunnen gebruiken
voor lijsten van kommagetallen, gehele getallen, strings, … Geef `null`
terug als de lijst leeg is.

### 2.3 Het visitor-patroon

**Oefening Vormen** In [dit IDEA-project](vormen.zip?raw=true)
definiëren we een interface `Vormen` met drie implementaties `Cirkel`,
`Rechthoek` en `RechthoekigeDriehoek`.

Pas het project aan zodat het voor alle bewerkingen op vormen een *visitor* gebruikt.
Uiteindelijk moet elke methode `oppervlakte`, `herschaal`, `isSymmetrisch` en `kopie`
uit het project verdwijnen en moeten we die gegevens op de volgende
manier kunnen opvragen:

    Vorm vorm = new ….
    double opp = Oppervlakte.van(vorm);
    Vorm vorm2 = Kopie.van(vorm);
    boolean symmetrisch = IsSymmetrisch.van(vorm);
    Herschaal.van(vorm, 3.5); 

De methode `herschaal` door een visitor vervangen is wellicht de moeilijkste
stap. *Tip* maak een visitorklasse `Herschaal` waarvan de *constructor*
de factor als parameter neemt. (Opgelet. De visit-methoden van `Herschaal` hebben nog steeds slechts één parameter.)

---
#### Oplossingen

Enkel wanneer het je zelf na een half uur nog niet lukt… (half uur per oefening!)

[Cowboy 2](Cowboy.java) |
[Maximizer](Maximizer.java) |
[Maximizer 2](MaximizerMethod.java) |
[Vormen](vormen-opl.zip?raw=true) |
