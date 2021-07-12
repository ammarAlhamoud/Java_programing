package Observer_Pattern_Beispiel;

import java.util.Observable;
import java.util.Observer;

public class Schuelerin implements Observer
{
	private String name;							// Name der Schülerin
	
	public Schuelerin(String name)					// Konstruktor
	{
		this.name = name;
		System.out.println("Schülerin " + name + ": Anwesend!");
	}
	
	public void update(Observable o, Object arg)	// Schülerin wird von Lehrer angesprochen
	{
		Lehrer l = (Lehrer) o;
		System.out.println("Schülerin " + name + ": Ich habe \"" + l.wasHabenSieGeradeGesagt() + "\" verstanden");
	}

}
