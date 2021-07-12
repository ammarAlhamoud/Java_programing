package FactoryMethod;

public class AppStarter {

	public static void main(String[] args) {		
	    GutschriftFakturierer Gf = new GutschriftFakturierer();
	    Gf.fakturiereDokument(10, null);
	    
	    RechnungFakturierer Rf = new RechnungFakturierer();
	    Rf.fakturiereDokument(12, Rechnungstype.Teilzahlungsrechnung);
	      

	}

}
