package FactoryMethod;

public class Rechnung extends Dokument{
	
	private float Rechnungbetrag;
	
	public Rechnung(int nr, Rechnungstype t) {
		super(nr, t);
	}

	public float getRechnungbetrag() {
		return Rechnungbetrag;
	}

	public void setGutschriftbetrag(float rechnungbetrag) {
		if(rechnungbetrag> 0)
			this.Rechnungbetrag= rechnungbetrag;
	}

}
