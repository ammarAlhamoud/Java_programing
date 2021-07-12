package  advVerwaltung_sprecher;
import java.util.Vector;

public class Klasse
{
	private String klBez;
	private String klRaum;
	private String klLehrer;
	private Vector<Schueler> alleSchueler;

	public Klasse(String klBez, String klRaum, String klLehrer)
	{
		this.klBez = klBez;
		this.klRaum = klRaum;
		this.klLehrer = klLehrer;
		alleSchueler = new Vector<Schueler>();
	}

	public String getKl_Bez()
	{
		return klBez;
	}

	public int getAnzahlSchüler()
	{
		return alleSchueler.size();
	}

	public void hinzufügenSchüler(Schueler neuerSchüler)
	{
		alleSchueler.addElement(neuerSchüler);
	}

	public String[] getAlleSchüler()
	{
		String[] schuelerDaten = new String[alleSchueler.size()];
		for (int i = 0; i < alleSchueler.size(); i++)
		{
			Schueler einSchüler = (Schueler) alleSchueler.elementAt(i);
			schuelerDaten[i] = einSchüler.getSchülerNr() + "\t"
			+ einSchüler.getName() + "\t" + einSchüler.getAdresse();
		}
		return schuelerDaten;
	}
	
//	Alternative: Vector von Schülern zurückgeben ==> "Zerlegen" in Attribute
//  Schülernr., Name, Adresse in AlleSchuelerGUI
//	public Vector<Schueler> getAlleSchüler()
//	{
//		return alleSchueler;
//	}

	public Schueler suchenSchüler(String schülerNr)
	{
		for (Schueler gesuchterSchueler : alleSchueler)
		{
			if (gesuchterSchueler.getSchülerNr().equals(schülerNr)) return gesuchterSchueler;
		}
		return null;
	}

	public boolean löschenSchüler(String schülerNr)
	{
		for (Schueler gesuchterSchueler : alleSchueler)
		{
			if (gesuchterSchueler.getSchülerNr().equals(schülerNr))
			{
				alleSchueler.remove(gesuchterSchueler);
				return true;
			}
		}
		return false;
	}
}