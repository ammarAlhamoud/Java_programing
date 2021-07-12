package abstractFacotry;

public abstract class GeschirrFabrik {
	
	public abstract Besteck ErzeugeBesteck(int gewicht);
	public abstract Teller ErzeugeTeller(int gewicht);
	public abstract Tassen ErzeugeTassen(int gewicht);
	
	public boolean checkBesteck(Besteck betsteck, int sollWert) {
		if (betsteck.getGewicht() == sollWert) {
			System.out.println("\t Dieses Produkt entspricht den Standardspezifikationen ");
			return true;
		}
		System.out.println("\t Dieses Produkt entspricht nicht den Standardspezifikationen");
		return false;
	}
	
	public boolean checkTeller(Teller teller, int sollWert) {
		if (teller.getGewicht() == sollWert) {
			System.out.println("\t Dieses Produkt entspricht den Standardspezifikationen ");
			return true;
		}
				
		System.out.println("\t Dieses Produkt entspricht nicht den Standardspezifikationen");
		return false;	
	}
	
	public boolean checkTassen(Tassen tassen, int sollWert) {
		if (tassen.getGewicht() == sollWert) {
			System.out.println("\t Dieses Produkt entspricht den Standardspezifikationen ");
			return true;
		}

		System.out.println("\t Dieses Produkt entspricht nicht den Standardspezifikationen");
		return false;	
	}





}
