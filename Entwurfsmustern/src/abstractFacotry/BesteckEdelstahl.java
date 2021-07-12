package abstractFacotry;

public class BesteckEdelstahl extends Besteck{

	public static int sollWert;

	public BesteckEdelstahl(int gewicht) {
		super(gewicht);
	}
	
	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}

}
