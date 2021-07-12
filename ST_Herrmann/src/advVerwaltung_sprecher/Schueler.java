package advVerwaltung_sprecher;

public class Schueler
{
	private String sch�lerNr;
	private String name;
	private String adresse;
	private Klasse klasse;

	public Schueler(String sch�lerNr, String name, String adresse)
	{
		this.sch�lerNr = sch�lerNr;
		this.name = name;
		this.adresse = adresse;
	}

	public String getSch�lerNr()
	{
		return sch�lerNr;
	}

	public String getName()
	{
		return name;
	}

	public String getAdresse()
	{
		return adresse;
	}

	public void zuordnenKlasse(Klasse klasse)
	{
		this.klasse = klasse;
	}
}