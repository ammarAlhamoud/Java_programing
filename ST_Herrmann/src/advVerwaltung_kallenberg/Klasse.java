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

    public int getAnzahlSchüler() {
        return alleSchueler.size();
    }

    public void hinzufügenSchüler(Schueler schueler) {
        alleSchueler.add(schueler);
    }


    public String[] getAlleSchuelerFormat() {
        //  Lösung 1: Die Schülerdaten in einem String-array, das die Größe des Schülervektors hat, in aufbereiteter Form speichern:
        //  jeweils die einzelnen Daten (Schülernr., ...) durch Blanks getrennt
        String[] schuelerDaten = new String[getAnzahlSchüler()];

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

    // Lösung 2 für getAlleSchüler(): den Schülervektor zurückgeben und die Datenaufbereitung dann vor dem Schreiben der
    // TextArea in AlleSchülerGUI machen

    public Schueler suchenSchüler(String schuelerNr) {
        // sog. "for each"-Schleife verwenden! (mit Doppelpunkt-Notation)
        for (Schueler s : alleSchueler) {
            if (s.getSchuelerNr().equals(schuelerNr)) {
                return s;
            }
        }

        return null;
    }

    public boolean löschenSchüler(String schuelerNr) {
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
