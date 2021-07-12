package Observer_Pattern_Aufgabe_Diagramme_Vorlage;
import java.util.Observable;

public class Daten extends Observable
{
	private int anteilArb; 		// Initialisierung: 35 (s. main-Methode)
	private int anteilAng; 		// 35
	private int anteilB; 		// 20
	private int anteilSelbst; 	// 10

	public Daten(int arb, int ang, int b, int selbst)
	{
		anteilArb = arb;
		anteilAng = ang;
		anteilB = b;
		anteilSelbst = selbst;
	}

	public void aendernDaten(int arb, int ang, int b, int selbst)
	{
		anteilArb = arb;
		anteilAng = ang;
		anteilB = b;
		anteilSelbst = selbst;
		
		setChanged(); 		// konkretes Subjekt wird als geändert 'markiert'
		notifyObservers(); 	// alle konkreten Beobachter werden benachrichtigt
							// dass sich das konkrete Subjekt geändert hat
	}

	public int getAnteilArb()
	{
		return anteilArb;
	}

	public int getAnteilAng()
	{
		return anteilAng;
	}

	public int getAnteilB()
	{
		return anteilB;
	}

	public int getAnteilSelbst()
	{
		return anteilSelbst;
	}
}
