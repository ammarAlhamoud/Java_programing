package abstractFacotry;


public class TellerTitan extends Teller {

	public static int sollWert;

	public TellerTitan(int gewicht) {
		super(gewicht);
	}
	
	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}
   
   
   }
