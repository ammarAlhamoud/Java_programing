package abstractFacotry;

public class TellerEdelstahl extends Teller{

	public static int sollWert;

	public TellerEdelstahl(int gewicht) {
		super(gewicht);
	}

	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}

}
