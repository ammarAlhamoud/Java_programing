package StrategyPattern;

public abstract class Auto {
	private String Modell;
	private double Preis;
	private boolean Zustand;
	
	HupenStrategy hupenStrategy = new Lauthupen();
	FahrenStrategy fahrenStrategy = new SchnellFahren();
	
	public Auto(String name, double preis, boolean zustand) {
		this.Modell = name;
		this.Preis = preis;
		this.Zustand = zustand;
	}
	
	public void hupen() {
		System.out.println("Auto wird hupen ...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		hupenStrategy.hupen();
	}
	
	public void fahren() {
		System.out.println("Auto wird fahren ...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		fahrenStrategy.fahren();
	}
	
	public void SetHupenStrategy(HupenStrategy hupenS) {
		this.hupenStrategy = hupenS;
	}
	
	public void SetFahrenStrategy(FahrenStrategy fahrenS) {
		this.fahrenStrategy = fahrenS;
	}
	
	public String getModell() {
		return Modell;
	}

	public void setModell(String modell) {
		Modell = modell;
	}

	public double getPreis() {
		return Preis;
	}

	public void setPreis(double preis) {
		Preis = preis;
	}

	public boolean isZustand() {
		return Zustand;
	}

	public void setZustand(boolean zustand) {
		Zustand = zustand;
	}
	
	

}
