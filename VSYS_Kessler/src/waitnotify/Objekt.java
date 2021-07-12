package waitnotify;

public class Objekt {

	private String	Inhalt;
	/* Flag, um anzuzeigen, ob Daten da sind */
	private boolean	fertig;

	public Objekt() {
		this.Inhalt = null;
		this.setFertig(false);
	}

	public String getInhalt() {
		return Inhalt;
	}

	public void setInhalt(String inhalt) {
		Inhalt = inhalt;
	}

	public boolean isFertig() {
		return fertig;
	}

	public void setFertig(boolean fertig) {
		this.fertig = fertig;
	}
}
