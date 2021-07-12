package aufgabe_wait_notify;

public class PPRessource {

	/* Benachrichtigungsanzeiger von Ping für Pong */
	private boolean	ping_fertig;
	/* Benachrichtigungsanzeiger von Pong für Ping */
	private boolean	pong_fertig;
	/* Daten des Objekts */
	private String	Inhalt;

	public PPRessource() {
		this.setInhalt(null);
		this.setPing_fertig(false);
		this.setPong_fertig(false);
	}

	public String getInhalt() {
		return Inhalt;
	}

	public void setInhalt(String inhalt) {
		Inhalt = inhalt;
	}

	public boolean isPing_fertig() {
		return ping_fertig;
	}

	public void setPing_fertig(boolean ping_fertig) {
		this.ping_fertig = ping_fertig;
	}

	public boolean isPong_fertig() {
		return pong_fertig;
	}

	public void setPong_fertig(boolean pong_fertig) {
		this.pong_fertig = pong_fertig;
	}
}
