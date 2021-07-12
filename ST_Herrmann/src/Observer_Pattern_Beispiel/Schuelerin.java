package Observer_Pattern_Beispiel;

import java.util.Observable;
import java.util.Observer;

public class Schuelerin implements Observer
{
	private String name;							// Name der Sch�lerin
	
	public Schuelerin(String name)					// Konstruktor
	{
		this.name = name;
		System.out.println("Sch�lerin " + name + ": Anwesend!");
	}
	
	public void update(Observable o, Object arg)	// Sch�lerin wird von Lehrer angesprochen
	{
		Lehrer l = (Lehrer) o;
		System.out.println("Sch�lerin " + name + ": Ich habe \"" + l.wasHabenSieGeradeGesagt() + "\" verstanden");
	}

}
