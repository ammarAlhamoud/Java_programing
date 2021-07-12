package FactoryMethod;

public class LieferscheinFakturierer extends Fakturierer{
	
	@Override
	public Dokument erzeugeDokument(int belegNr, Rechnungstype type) {
		System.out.println("\t das Doukument ist vom Type Lieferschein");
		return new Lieferschein(belegNr, type);
	}	

}
