package abstractFacotry;

public class BesteckPlastik extends Besteck{

	public static int sollWert;

	public BesteckPlastik(int gewicht) {
		super(gewicht);
	}
	
	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}

}
