package FactoryMethod;

public class GutschriftFakturierer extends Fakturierer{

	@Override
	public Dokument erzeugeDokument(int belegNr, Rechnungstype type) {
		System.out.println("\t das Doukument ist vom Type Gutschrift");
		return new Gutschrift(belegNr, type);
	}	

}
