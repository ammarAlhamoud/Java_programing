package asynchron.parallel;

public class Steuerung {

	private boolean	fertig;

	public Steuerung() {
		this.fertig = false;
	}

	public boolean isFertig() {
		return fertig;
	}

	public void setFertig(boolean fertig) {
		this.fertig = fertig;
	}

}
