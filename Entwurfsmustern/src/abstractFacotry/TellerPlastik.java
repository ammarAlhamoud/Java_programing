package abstractFacotry;

public class TellerPlastik extends Teller{

	public static int sollWert;

	public TellerPlastik(int gewicht) {
		super(gewicht);
	}
	
	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}

}
