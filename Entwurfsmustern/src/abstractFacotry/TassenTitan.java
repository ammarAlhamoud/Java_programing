package abstractFacotry;


public class TassenTitan extends Tassen {

	public static int sollWert;

	public TassenTitan(int gewicht) {
		super(gewicht);
	}
		
	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}
   
   }
