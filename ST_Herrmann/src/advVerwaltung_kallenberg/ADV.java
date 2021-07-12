package advVerwaltung_kallenberg;

import java.util.Vector;

public class ADV {
    // die Klasse ADV ist hier eine Klasse, die nur static-Attribute und
    // static-Methoden
    // bereitstellt (vgl. Standardklasse Math), da diese Informationen sich
    // nicht �ndern
    // Alternative w�re: eine Singleton-Klasse definieren (nach singleton
    // pattern), von der
    // nur ein einziges Objekt erzeugt werden kann ==> sp�ter! (Thema design
    // patterns)
    private static String bezeichnung = "Akademie f�r Datenverarbeitung";
    private static String adresse = "Danziger Str. 6, 71034 B�blingen";
    private static String telNr = "Verwaltung: 07031 - 627 - 0";
    private static String emailAdresse = "verwaltg@adv-boeblingen.de";
    private static int anzahlSch�ler;

    // f�r 1:n Beziehung zu Klasse
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

    public static int getAnzahlSch�ler() {
        // sog. "for each"- Schleife verwenden! (mit Doppelpunkt-Notation)
        int anzahlSchueler = 0;
        for (Klasse klasse : alleKlassen) {
            anzahlSchueler += klasse.getAnzahlSch�ler();
        }

        return anzahlSchueler;
    }

    public static boolean hinzuf�genKlasse(Klasse klasse) {
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