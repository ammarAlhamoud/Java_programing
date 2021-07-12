package StrategyPattern;

public class DefektFahren implements FahrenStrategy{

	public void fahren() {
		System.out.println("ich bin defekt!, ich kann nicht mehr fahren :(");
	}

}
