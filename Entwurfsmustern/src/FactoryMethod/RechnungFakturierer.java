package FactoryMethod;

public class RechnungFakturierer extends Fakturierer{
	
	@Override
	public Dokument erzeugeDokument(int belegNr, Rechnungstype type) {
		
		switch(type) {
		
		case Nachnahmerechnung : 
			System.out.println("\t das Doukument ist vom Type Nachnahmerechnung");
			return new Nachnahmerechnung(belegNr, type); 
		case Vorausrechnung : 
			System.out.println("\t das Doukument ist vom Type Vorausrechnung");
			return new Vorausrechnung(belegNr, type); 
		case Teilzahlungsrechnung :
			System.out.println("\t das Doukument ist vom Type Teilzahlungsrechnung");
			return new Teilzahlungsrechnung(belegNr, type); 
		default:
			System.out.println("\t das Doukument ist vom Type Rechnung");
			return new Rechnung(belegNr, null);
		

		}
		
	}

}
