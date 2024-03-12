Objectgericht programmeren - week 4
===

### 3-3.3 Persistente informatie in tekstbestanden

**Oefening Langste Woord 1** Wat is het langste woord in het Nederlands? 

Schrijf een programma
dat het langste woord zoekt in een specifieke woordenlijst.
We lezen die woordenlijst van het Internet met de volgende Java-code 
die een *input stream* opent voor die lijst:

    URL url = new URL("https://raw.githubusercontent.com/OpenTaal/opentaal-wordlist/master/elements/basiswoorden-gekeurd.txt");
    InputStream in = url.openStream();

De lijst is opgesteld in UTF-8-codering. Elke lijn bevat één woord of uitdrukking. Kijk enkel naar lijnen die 
geen spatie bevatten. Gebruik een `BufferedReader`. Vang uitzonderingen op met een try-met-bronnen. 

### 3.4 Bestanden lezen uit het class path

**Oefening Langste Woord 2** Zelfde oefening als versie 1, maar lees het bestand uit het *class path*.

### 3.7 Eigenschapsbestanden

### 4.1 Scènes bouwen zonder FXML

**Oefening Countdown 4** Herschrijf het programma [Countdown](https://inigem.ugent.be/jvlfx/Countdown3.zip?raw=true) (derde versie) uit de zelfstudienota's
zodat het niet langer FXML gebruikt. Je maakt hierbij best een nieuwe component `CountdownPane` aan.
(En vervang dan ook `BorderPane` in het CSS-bestand door `CountdownPane`.)

---

#### Oplossingen

Enkel wanneer het je zelf na een half uur nog niet lukt… (half uur per oefening!)

[Langste Woord 1](LangsteWoord1.java) |
[Langste Woord 2](LangsteWoord2.java) |
[Countdown 4](countdown4.zip?raw=true)

