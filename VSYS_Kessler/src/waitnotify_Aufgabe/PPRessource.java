package waitnotify_Aufgabe;



public class PPRessource {
	private String	Inhalt;
	private boolean	fertig;

	public PPRessource() {
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
