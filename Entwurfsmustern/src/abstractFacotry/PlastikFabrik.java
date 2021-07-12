package abstractFacotry;

public class PlastikFabrik extends GeschirrFabrik{

	private int besteckSollWert;
	private int tassenSollWert;
	private int tellerSollWert;
	
	public PlastikFabrik(int besteckSollWert,int tassenSollWert,int tellerSollWert) {
		BesteckPlastik.sollWert = besteckSollWert;
		this.besteckSollWert = besteckSollWert;
				
		TassenPlastik.sollWert = tassenSollWert;
		this.tassenSollWert = tassenSollWert;
		
		TellerPlastik.sollWert = tellerSollWert;
		this.tellerSollWert = tellerSollWert;
	}
	
	@Override
	public Besteck ErzeugeBesteck(int gewicht) {
		Besteck newBesteck = new BesteckPlastik(gewicht);
		System.out.println("Ein neues Besteck mit dem Gewicht: " + newBesteck.getGewicht()
		+ " vom Type Plastik wurde erstellt");
		checkBesteck(newBesteck, besteckSollWert);
		return newBesteck;
	}

	@Override
	public Teller ErzeugeTeller(int gewicht) {
		Teller newTeller = new TellerPlastik(gewicht);
		System.out.println("Ein neuer Teller mit dem Gewicht: " + newTeller.getGewicht()
		+ " vom Type Plastik wurde erstellt");
		checkTeller(newTeller,tellerSollWert);

		return newTeller;
	}

	@Override
	public Tassen ErzeugeTassen(int gewicht) {
		Tassen newTassen = new TassenPlastik(gewicht);
		System.out.println("Eine neue Tasse mit dem Gewicht: " + newTassen.getGewicht()
		+ " vom Type Plastik wurde erstellt");
		checkTassen(newTassen,tassenSollWert);

		return newTassen;
	}

}
