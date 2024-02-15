package be.ugent.objprog.cowboy;

public enum Alignment {


    LEFT {
        public String align(String line, int width) {
            return line;
        }
    },

    CENTER {
        public String align(String line, int width) {
            // we kunnen 'spaces' niet gebruiken zoals in het origineel, omdat die afhangt van width
            // we kiezen voor een gemakkelijkheidsoplossing die misschien iets minder efficient is
            return " ".repeat((width - line.length())/2) + line;
        }
    },

    RIGHT {
        public String align(String line, int width) {
            return " ".repeat(width - line.length())+ line;
        }
    };

    /* Opmerking

       Hier kiezen we ervoor om het opsomtype de extra spaties vooraan de string te laten toevoegen.
       Als alternatief hadden we ook dit resultaat hier ook meteen kunnen afdrukken of anders in deze
       klasse enkel het aantal toe te voegen spaties te berekenen - wat trouwens ons 'probleem' met
       spaces (zie commentaar bij CENTER hierboven) zou oplossen.
     */
    public abstract String align (String line, int width);
}
