package abstractFacotry;


public class BesteckTitan extends Besteck {
	
	public static int sollWert;

	public BesteckTitan(int gewicht) {
		super(gewicht);
	}
	
	public int getSollWert() {
		return sollWert;
	}

	public void setSollWert(int sollWert) {
		this.sollWert = sollWert;
	}
   
   }
