package Observer_Pattern_Beispiel;

import java.util.Observable;

public class Lehrer extends Observable
{
	private String nachricht;						// Nachricht an die Schüler(innen)
	
	public Lehrer()									// Konstruktor
	{
		System.out.println("Lehrer: Anwesend!");
	}
	
	public void sprich(String nachricht)			// Lehrer sprich etwas zu den Schüler(inne)n
	{
		this.nachricht = nachricht;
		System.out.println("Lehrer: " + nachricht);
		setChanged();
		notifyObservers();
	}
	
	public String wasHabenSieGeradeGesagt()			// Lehrer, was haben Sie gerade gesagt?
	{
		return nachricht;
	}
}
