package StrategyPattern;

public class Client {

	public static void main(String[] args) {
		BMW newBmw= new BMW(25000, true);
		Audi newAudi= new Audi(10000, false);
		
		newBmw.fahren();
		newBmw.hupen();
		
		newAudi.fahren();
		newAudi.hupen();
		
		newBmw.SetFahrenStrategy(new DefektFahren());
		newBmw.fahren();
		newBmw.hupen();
		
		newAudi.SetFahrenStrategy(new SchnellFahren());
		newAudi.SetHupenStrategy(new Lauthupen());
		newAudi.fahren();
		newAudi.hupen();
	}

}
