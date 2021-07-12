package advVerwaltung_sprecher;
import java.util.Vector;

public class ADV
{
	// die Klasse ADV ist hier eine Klasse, die nur static-Attribute und
	// static-Methoden
	// bereitstellt (vgl. Standardklasse Math), da diese Informationen sich
	// nicht �ndern
	// Alternative w�re: eine Singleton-Klasse definieren (nach singleton
	// pattern), von der
	// nur ein einziges Objekt erzeugt werden kann (Thema design
	// patterns)
	private static String bezeichnung = "Akademie f�r Datenverarbeitung";
	private static String adresse = "Danziger Str. 6, 71034 B�blingen";
	private static String telNr = "Verwaltung: 07031 - 627 - 0";
	private static String emailAdresse = "info-adv@gds2.de";
	private static int anzahlSch�ler;
	// f�r 1:n Beziehung zu Klasse
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

	public static int getAnzahlSch�ler()
	{
		anzahlSch�ler = 0;
		for (Klasse klasse : klassen)
		{
			anzahlSch�ler += klasse.getAnzahlSch�ler();
		}
		return anzahlSch�ler;
	}

	public static boolean hinzuf�genKlasse(Klasse neueKlasse)
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