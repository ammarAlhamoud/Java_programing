package StrategyPattern;

public class BMW extends Auto{

	public BMW(double preis, boolean zustand) {
		super("BMW", preis, zustand);
		
		System.out.println("Neue Auto von Modell BMW wurde erstellt, Preis: " + preis
				+ ", Zustand: " + zustand);
		
		SetHupenStrategy(new Lauthupen());
		SetFahrenStrategy(new SchnellFahren());
	}
	
}
