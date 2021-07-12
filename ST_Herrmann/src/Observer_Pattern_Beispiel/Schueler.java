package Observer_Pattern_Beispiel;

import java.util.Observable;
import java.util.Observer;

public class Schueler implements Observer
{
	private String name;							// Name des Schülers
	
	public Schueler(String name)					// Konstruktor
	{
		this.name = name;
		System.out.println("Schüler " + name + ": Anwesend!");
	}
	
	public void update(Observable o, Object arg)	// Schüler wird von Lehrer angesprochen
	{
		Lehrer l = (Lehrer) o;
		System.out.println("Schüler " + name + ": Ich habe \"" + l.wasHabenSieGeradeGesagt() + "\" verstanden");
	}

}
