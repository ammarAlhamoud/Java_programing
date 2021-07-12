package advVerwaltung_kallenberg;

import java.util.Vector;

public class Klasse {
    private String klBez;
    private String klRaum;
    private String klLehrer;
    private Vector<Schueler> alleSchueler;

    public Klasse(String klBez, String klRaum, String klLehrer) {
        this.klBez = klBez;
        this.klRaum = klRaum;
        this.klLehrer = klLehrer;
        alleSchueler = new Vector<>();
    }

    public String getKl_Bez() {
        return klBez;
    }

    public int getAnzahlSch�ler() {
        return alleSchueler.size();
    }

    public void hinzuf�genSch�ler(Schueler schueler) {
        alleSchueler.add(schueler);
    }


    public String[] getAlleSchuelerFormat() {
        //  L�sung 1: Die Sch�lerdaten in einem String-array, das die Gr��e des Sch�lervektors hat, in aufbereiteter Form speichern:
        //  jeweils die einzelnen Daten (Sch�lernr., ...) durch Blanks getrennt
        String[] schuelerDaten = new String[getAnzahlSch�ler()];

        for (int i = 0; i < schuelerDaten.length; i++) {
            Schueler s = alleSchueler.get(i);
            // TODO: nicer format
            String daten = String.format("%s %s %s", s.getSchuelerNr(), s.getName(), s.getAdresse());

            schuelerDaten[i] = daten;
        }

        return schuelerDaten;
    }

    public Vector<Schueler> getAlleSchueler() {
        return alleSchueler;
    }

    // L�sung 2 f�r getAlleSch�ler(): den Sch�lervektor zur�ckgeben und die Datenaufbereitung dann vor dem Schreiben der
    // TextArea in AlleSch�lerGUI machen

    public Schueler suchenSch�ler(String schuelerNr) {
        // sog. "for each"-Schleife verwenden! (mit Doppelpunkt-Notation)
        for (Schueler s : alleSchueler) {
            if (s.getSchuelerNr().equals(schuelerNr)) {
                return s;
            }
        }

        return null;
    }

    public boolean l�schenSch�ler(String schuelerNr) {
        // sog. "for each"-Schleife verwenden! (mit Doppelpunkt-Notation)
        for (Schueler s : alleSchueler) {
            if (s.getSchuelerNr().equals(schuelerNr)) {
                alleSchueler.remove(s);
                return true;
            }
        }

        return false;
    }
}
