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

	public int getAnzahlSch�ler()
	{
		return alleSchueler.size();
	}

	public void hinzuf�genSch�ler(Schueler neuerSch�ler)
	{
		alleSchueler.addElement(neuerSch�ler);
	}

	public String[] getAlleSch�ler()
	{
		String[] schuelerDaten = new String[alleSchueler.size()];
		for (int i = 0; i < alleSchueler.size(); i++)
		{
			Schueler einSch�ler = (Schueler) alleSchueler.elementAt(i);
			schuelerDaten[i] = einSch�ler.getSch�lerNr() + "\t"
			+ einSch�ler.getName() + "\t" + einSch�ler.getAdresse();
		}
		return schuelerDaten;
	}
	
//	Alternative: Vector von Sch�lern zur�ckgeben ==> "Zerlegen" in Attribute
//  Sch�lernr., Name, Adresse in AlleSchuelerGUI
//	public Vector<Schueler> getAlleSch�ler()
//	{
//		return alleSchueler;
//	}

	public Schueler suchenSch�ler(String sch�lerNr)
	{
		for (Schueler gesuchterSchueler : alleSchueler)
		{
			if (gesuchterSchueler.getSch�lerNr().equals(sch�lerNr)) return gesuchterSchueler;
		}
		return null;
	}

	public boolean l�schenSch�ler(String sch�lerNr)
	{
		for (Schueler gesuchterSchueler : alleSchueler)
		{
			if (gesuchterSchueler.getSch�lerNr().equals(sch�lerNr))
			{
				alleSchueler.remove(gesuchterSchueler);
				return true;
			}
		}
		return false;
	}
}