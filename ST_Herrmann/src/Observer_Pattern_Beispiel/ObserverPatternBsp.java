package Observer_Pattern_Beispiel;
public class ObserverPatternBsp
{

	public static void main(String[] args) {
		Lehrer l = new Lehrer();					// Erzeuge Lehrer
		
		Schueler schueler1 = new Schueler("Hans");			// Erzeuge neuen Sch�ler
		Schuelerin schuelerin1 = new Schuelerin("Helga");	// Erzeuge neue Sch�lerin
		Schueler schueler2 = new Schueler("Thomas");		// Erzeuge neuen Sch�ler

		l.addObserver(schueler1);							// Sch�ler 1 h�rt Lehrer zu
		l.addObserver(schuelerin1);							// Sch�lerin 1 h�rt Lehrer zu

		
		l.sprich("Guten Morgen!");							// Lehrer spricht
		
		l.addObserver(schueler2);							// Sch�ler 2 war vorerst unaufmerksam,
															// h�rt aber jetzt dem Lehrer zu
		
		l.sprich("Tsch�ss!");								// Lehrer spricht nochmal
	}

}
