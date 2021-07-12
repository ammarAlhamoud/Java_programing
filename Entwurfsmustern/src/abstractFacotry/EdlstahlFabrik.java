package abstractFacotry;

public class EdlstahlFabrik extends GeschirrFabrik{

	private int besteckSollWert;
	private int tassenSollWert;
	private int tellerSollWert;
	
	public EdlstahlFabrik(int besteckSollWert,int tassenSollWert,int tellerSollWert) {
		BesteckEdelstahl.sollWert = besteckSollWert;
		this.besteckSollWert = besteckSollWert;
				
		TassenEdelstahl.sollWert = tassenSollWert;
		this.tassenSollWert = tassenSollWert;
		
		TellerEdelstahl.sollWert = tellerSollWert;
		this.tellerSollWert = tellerSollWert;
	}
	
	@Override
	public Besteck ErzeugeBesteck(int gewicht) {
		Besteck newBesteck = new BesteckEdelstahl(gewicht);
		System.out.println("Ein neues Besteck mit dem Gewicht: " + newBesteck.getGewicht()
		+ " vom Type Edelstahl wurde erstellt");
		checkBesteck(newBesteck, besteckSollWert);
		return newBesteck;
	}

	@Override
	public Teller ErzeugeTeller(int gewicht) {
		Teller newTeller = new TellerEdelstahl(gewicht);
		System.out.println("Ein neuer Teller mit dem Gewicht: " + newTeller.getGewicht()
		+ " vom Type Edelstahl wurde erstellt");
		checkTeller(newTeller,tellerSollWert);

		return newTeller;
	}

	@Override
	public Tassen ErzeugeTassen(int gewicht) {
		Tassen newTassen = new TassenEdelstahl(gewicht);
		System.out.println("Eine neue Tasse mit dem Gewicht: " + newTassen.getGewicht()
		+ " vom Type Edelstahl wurde erstellt");
		checkTassen(newTassen,tassenSollWert);

		return newTassen;
	}
}
