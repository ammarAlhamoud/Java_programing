package abstractFacotry;

public abstract class Besteck {
	private int Gewicht;
	
	public Besteck(int gewicht) {
		this.Gewicht = gewicht;
	}

	public int getGewicht() {
		return Gewicht;
	}

	public void setGewicht(int gewicht) {
		Gewicht = gewicht;
	}

}
