package advVerwaltung_sprecher;

public class Schueler
{
	private String schülerNr;
	private String name;
	private String adresse;
	private Klasse klasse;

	public Schueler(String schülerNr, String name, String adresse)
	{
		this.schülerNr = schülerNr;
		this.name = name;
		this.adresse = adresse;
	}

	public String getSchülerNr()
	{
		return schülerNr;
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