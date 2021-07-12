package FactoryMethod;

public abstract class Fakturierer {
	
	public abstract Dokument erzeugeDokument(int belegNr, Rechnungstype type);
	
	public void fakturiereDokument(int belegNr, Rechnungstype t) {
		Dokument doku = erzeugeDokument(belegNr, t);
		
		if(!isValid(doku)) 
			throw new IllegalArgumentException("Das zu verarbeitende Dokument ist nicht gültig");
		else
			System.out.println("Ein Doukument mit der Betrag Nr. " + doku.getBelegnummer() + " wurde erstellt");
	}
	
	public boolean isValid(Dokument dokument){
		if(dokument.getBelegnummer() < 0)
			return false;
		return true;
	}

}
