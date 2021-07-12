package StrategyPattern;

public class Audi extends Auto{

	public Audi(double preis, boolean zustand) {
		super("Audi", preis, zustand);
		
		System.out.println("Neue Auto von Modell Audi wurde erstellt, Preis: " + preis
				+ ", Zustand: " + zustand);
		
		SetHupenStrategy(new LeiseHupen());
		SetFahrenStrategy(new langsamFahren());


	}	
	
}
