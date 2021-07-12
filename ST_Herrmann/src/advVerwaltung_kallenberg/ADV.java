package advVerwaltung_kallenberg;

import java.util.Vector;

public class ADV {
    // die Klasse ADV ist hier eine Klasse, die nur static-Attribute und
    // static-Methoden
    // bereitstellt (vgl. Standardklasse Math), da diese Informationen sich
    // nicht ändern
    // Alternative wäre: eine Singleton-Klasse definieren (nach singleton
    // pattern), von der
    // nur ein einziges Objekt erzeugt werden kann ==> später! (Thema design
    // patterns)
    private static String bezeichnung = "Akademie für Datenverarbeitung";
    private static String adresse = "Danziger Str. 6, 71034 Böblingen";
    private static String telNr = "Verwaltung: 07031 - 627 - 0";
    private static String emailAdresse = "verwaltg@adv-boeblingen.de";
    private static int anzahlSchüler;

    // für 1:n Beziehung zu Klasse
    private static Vector<Klasse> alleKlassen = new Vector<>();

    public static String getBezeichnung() {
        return bezeichnung;
    }

    public static String getAdresse() {
        return adresse;
    }

    public static String getTelNr() {
        return telNr;
    }

    public static String getEmail() {
        return emailAdresse;
    }

    public static int getAnzahlKlassen() {
        return alleKlassen.size();
    }

    public static int getAnzahlSchüler() {
        // sog. "for each"- Schleife verwenden! (mit Doppelpunkt-Notation)
        int anzahlSchueler = 0;
        for (Klasse klasse : alleKlassen) {
            anzahlSchueler += klasse.getAnzahlSchüler();
        }

        return anzahlSchueler;
    }

    public static boolean hinzufügenKlasse(Klasse klasse) {
        return alleKlassen.add(klasse);
    }

    public static Klasse suchenKlasse(String kl_Bez) {
        // sog. "for each"- Schleife verwenden! (mit Doppelpunkt-Notation)
        for (Klasse k : alleKlassen) {
            if (k.getKl_Bez().equals(kl_Bez)) {
                return k;
            }
        }

        return null;
    }

    public static Vector<Klasse> getAlleKlassen() {
        return alleKlassen;
    }
}