package abstractFacotry;

public abstract class Tassen {
	private int Gewicht;
	
	public Tassen(int gewicht) {
		this.Gewicht = gewicht;
	}

	public int getGewicht() {
		return Gewicht;
	}

	public void setGewicht(int gewicht) {
		Gewicht = gewicht;
	}

}
