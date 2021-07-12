package abstractFacotry;

public class TassenPlastik extends Tassen{

	public static int sollWert;

	public TassenPlastik(int gewicht) {
		super(gewicht);
	}

	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}

}
