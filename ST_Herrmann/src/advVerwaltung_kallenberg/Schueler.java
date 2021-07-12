package advVerwaltung_kallenberg;

public class Schueler {
    private String schuelerNr;
    private String name;
    private String adresse;
    // n:1 - Beziehung zu Klasse
    private Klasse klasse;


    public Schueler(String schuelerNr, String name, String adresse) {
        this.schuelerNr = schuelerNr;
        this.name = name;
        this.adresse = adresse;
    }

    public String getSchuelerNr() {
        return schuelerNr;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void zuordnenKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public String getKlasse() {
        return klasse.getKl_Bez();
    }
}