package Observer_Pattern_Beispiel;

import java.util.Observable;
import java.util.Observer;

public class Schueler implements Observer
{
	private String name;							// Name des Sch�lers
	
	public Schueler(String name)					// Konstruktor
	{
		this.name = name;
		System.out.println("Sch�ler " + name + ": Anwesend!");
	}
	
	public void update(Observable o, Object arg)	// Sch�ler wird von Lehrer angesprochen
	{
		Lehrer l = (Lehrer) o;
		System.out.println("Sch�ler " + name + ": Ich habe \"" + l.wasHabenSieGeradeGesagt() + "\" verstanden");
	}

}
