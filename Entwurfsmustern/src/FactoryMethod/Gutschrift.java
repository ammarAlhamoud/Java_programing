package FactoryMethod;

public class Gutschrift extends Dokument{
	
	private float Gutschriftbetrag;
		
	public Gutschrift(int nr, Rechnungstype t) {
		super(nr, t);
	}

	public float getGutschriftbetrag() {
		return Gutschriftbetrag;
	}

	public void setGutschriftbetrag(float gutschriftbetrag) {
		if(gutschriftbetrag> 0)
			this.Gutschriftbetrag= gutschriftbetrag;
	}
		
}
