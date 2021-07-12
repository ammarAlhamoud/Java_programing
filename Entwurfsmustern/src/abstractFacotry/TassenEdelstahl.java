package abstractFacotry;

public class TassenEdelstahl extends Tassen{

	public static int sollWert;

	public TassenEdelstahl(int gewicht) {
		super(gewicht);
	}
	
	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}

}
