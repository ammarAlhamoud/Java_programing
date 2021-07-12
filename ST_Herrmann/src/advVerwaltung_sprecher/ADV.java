package advVerwaltung_sprecher;
import java.util.Vector;

public class ADV
{
	// die Klasse ADV ist hier eine Klasse, die nur static-Attribute und
	// static-Methoden
	// bereitstellt (vgl. Standardklasse Math), da diese Informationen sich
	// nicht ändern
	// Alternative wäre: eine Singleton-Klasse definieren (nach singleton
	// pattern), von der
	// nur ein einziges Objekt erzeugt werden kann (Thema design
	// patterns)
	private static String bezeichnung = "Akademie für Datenverarbeitung";
	private static String adresse = "Danziger Str. 6, 71034 Böblingen";
	private static String telNr = "Verwaltung: 07031 - 627 - 0";
	private static String emailAdresse = "info-adv@gds2.de";
	private static int anzahlSchüler;
	// für 1:n Beziehung zu Klasse
	private static Vector<Klasse> klassen = new Vector<Klasse>();

	public static String getBezeichnung()
	{
		return bezeichnung;
	}

	public static String getAdresse()
	{
		return adresse;
	}

	public static String getTelNr()
	{
		return telNr;
	}

	public static String getEmail()
	{
		return emailAdresse;
	}

	public static int getAnzahlKlassen()
	{
		return klassen.size();
	}

	public static int getAnzahlSchüler()
	{
		anzahlSchüler = 0;
		for (Klasse klasse : klassen)
		{
			anzahlSchüler += klasse.getAnzahlSchüler();
		}
		return anzahlSchüler;
	}

	public static boolean hinzufügenKlasse(Klasse neueKlasse)
	{		
		return klassen.add(neueKlasse);
	}

	public static Klasse suchenKlasse(String kl_Bez)
	{
		for (Klasse gesuchteKlasse : klassen)
		{
			if (gesuchteKlasse.getKl_Bez().equals(kl_Bez))
				return (gesuchteKlasse);
		}
		return (null);
	}
}