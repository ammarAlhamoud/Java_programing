package Observer_Pattern_Beispiel;
public class ObserverPatternBsp
{

	public static void main(String[] args) {
		Lehrer l = new Lehrer();					// Erzeuge Lehrer
		
		Schueler schueler1 = new Schueler("Hans");			// Erzeuge neuen Schüler
		Schuelerin schuelerin1 = new Schuelerin("Helga");	// Erzeuge neue Schülerin
		Schueler schueler2 = new Schueler("Thomas");		// Erzeuge neuen Schüler

		l.addObserver(schueler1);							// Schüler 1 hört Lehrer zu
		l.addObserver(schuelerin1);							// Schülerin 1 hört Lehrer zu

		
		l.sprich("Guten Morgen!");							// Lehrer spricht
		
		l.addObserver(schueler2);							// Schüler 2 war vorerst unaufmerksam,
															// hört aber jetzt dem Lehrer zu
		
		l.sprich("Tschüss!");								// Lehrer spricht nochmal
	}

}
