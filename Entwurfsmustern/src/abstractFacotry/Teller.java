package abstractFacotry;

public abstract class Teller {
	private int Gewicht;

	public Teller(int gewicht) {
		this.Gewicht = gewicht;
	}

	public int getGewicht() {
		return Gewicht;
	}

	public void setGewicht(int gewicht) {
		Gewicht = gewicht;
	}

}
