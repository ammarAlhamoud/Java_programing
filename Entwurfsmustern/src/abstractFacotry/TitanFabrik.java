package abstractFacotry;

public class TitanFabrik extends GeschirrFabrik {

	private int besteckSollWert;
	private int tassenSollWert;
	private int tellerSollWert;
	
	public TitanFabrik(int besteckSollWert,int tassenSollWert,int tellerSollWert) {
		BesteckTitan.sollWert = besteckSollWert;
		this.besteckSollWert = besteckSollWert;
				
		TassenTitan.sollWert = tassenSollWert;
		this.tassenSollWert = tassenSollWert;
		
		TellerTitan.sollWert = tellerSollWert;
		this.tellerSollWert = tellerSollWert;
		
	}
	
	@Override
	public Besteck ErzeugeBesteck(int gewicht) {
		Besteck newBesteck = new BesteckTitan(gewicht);
		System.out.println("Ein neues Besteck mit dem Gewicht: " + newBesteck.getGewicht()
				+ " vom Type Titan wurde erstellt");
		checkBesteck(newBesteck, besteckSollWert);
		return newBesteck;
	}

	@Override
	public Teller ErzeugeTeller(int gewicht) {
		Teller newTeller = new TellerTitan(gewicht);
		System.out.println("Ein neuer Teller mit dem Gewicht: " + newTeller.getGewicht()
		+ " vom Type Titan wurde erstellt");
		checkTeller(newTeller,tellerSollWert);
		return newTeller;
	}

	@Override
	public Tassen ErzeugeTassen(int gewicht) {
		Tassen newTassen = new TassenTitan(gewicht);
		System.out.println("Eine neue Tasse mit dem Gewicht: " + newTassen.getGewicht()
		+ " vom Type Titan wurde erstellt");
		checkTassen(newTassen,tassenSollWert);
		return newTassen;
	}

   
   }
