package FactoryMethod;

public class Lieferschein extends Dokument{
	
	private float Lieferscheinbetrag;
	
	public Lieferschein(int nr, Rechnungstype t) {
		super(nr, t);
	}

	public float getLieferscheinbetrag() {
		return Lieferscheinbetrag;
	}

	public void setLieferscheinbetrag(float lieferscheinbetrag) {
		if(lieferscheinbetrag> 0)
			this.Lieferscheinbetrag= lieferscheinbetrag;
	}

}
